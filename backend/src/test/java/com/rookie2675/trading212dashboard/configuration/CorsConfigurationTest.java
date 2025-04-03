package com.rookie2675.trading212dashboard.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@ContextConfiguration(classes = {CorsConfiguration.class})
class CorsConfigurationTest {

    private final MockMvc mockMvc;
    private static final String MOCK_ENDPOINT = "/api/test";
    private static final String UNAUTHORIZED_ORIGIN = "http://unauthorized-domain.com";
    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";

    @Autowired
    CorsConfigurationTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void testCorsConfigurationWithAllowedOrigin() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .options(MOCK_ENDPOINT)
                .header("Origin", CorsConfiguration.getAllowedOrigin())
                .header("Access-Control-Request-Method", "GET");

        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.header().exists(ACCESS_CONTROL_ALLOW_ORIGIN))
                .andExpect(MockMvcResultMatchers
                        .header()
                        .string(ACCESS_CONTROL_ALLOW_ORIGIN, CorsConfiguration.getAllowedOrigin()));
    }

    @Test
    public void testCorsConfigurationWithDisallowedOrigin() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .options(MOCK_ENDPOINT)
                .header("Origin", UNAUTHORIZED_ORIGIN)
                .header("Access-Control-Request-Method", "GET");

        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.header().doesNotExist(ACCESS_CONTROL_ALLOW_ORIGIN));
    }
}