package com.microservice.ApiGateway.filter;

import com.microservice.ApiGateway.exception.CustomException;
import com.microservice.ApiGateway.security.JwtHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.ws.rs.core.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
    @Autowired
    private RouteValidator validator;
    @Autowired
    private JwtHelper jwtHelper;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {

                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new CustomException("Missing authorization header");
                }

                String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
                //authHeade has the token
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    String token = authHeader.substring(7);
                    try {
                        jwtHelper.valiDateToken(token);
                        Claims cliams = jwtHelper.getAllClaimsFromToken(token);

                        // get cliams from the token
                        // payload data from the token (Cliams)
                        //it has roles , sub, iat , exp

                        List<Map<String, String>> authorities = (List<Map<String, String>>) cliams.get("roles");

                        String rolesInToken = authorities.getFirst().get("authority");
                        //getting roles of the Cliams of token

                        List<String> roles = new ArrayList<>();

                        roles.add(rolesInToken);

                        if (roles == null || !hasRequiredRole(roles, config.getRole())) {
                            // checking the roles is sufficeiwnt or not else throw error
                            throw new CustomException("Insufficient role");
                        }
                    } catch (ExpiredJwtException e) {
                        System.out.println("JWT Token has expired: " + e.getMessage());
                        throw new CustomException("JWT Token has expired: " + e.getMessage());
                    } catch (MalformedJwtException e) {
                        throw new CustomException("JWT Token is malformed: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("JWT Token validation error: " + e.getMessage());

                        throw new CustomException("Unauthorized access to application  " + e.getMessage());
                    }
                } else {
                    System.out.println("Invalid Authorization header format");
                    throw new CustomException("Invalid Authorization header format");
                }

            }

            return chain.filter(exchange);
        };
    }

    private boolean hasRequiredRole(List<String> userRoles, Set<String> requiredRoles) {
        for (String role : requiredRoles) {
            if (userRoles.contains(role)) {
                return true;
            }
        }
        return false;
    }

    public static class Config {

        private Set<String> role;

        public Set<String> getRole() {
            return role;
        }

        public void setRole(Set<String> role) {
            this.role = role;
        }
    }
}
