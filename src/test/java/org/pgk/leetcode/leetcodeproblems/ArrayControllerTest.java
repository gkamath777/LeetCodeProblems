package org.pgk.leetcode.leetcodeproblems;

import org.junit.jupiter.api.Test;
import org.pgk.leetcode.leetcodeproblems.controller.ArrayController;
import org.pgk.leetcode.leetcodeproblems.service.ArrayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArrayController.class)
public class ArrayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ArrayServiceImpl arrayService;

    @Test
    void getConcate() throws Exception {

        when(arrayService.getConcatenation(new int[]{1,2}))
                .thenReturn(new int[]{1, 2, 1, 2});

        mockMvc.perform(get("/array/concat")
                .param("nums", "1, 2"))
                .andExpect(status().isOk())
                .andExpect(content().json("[1, 2, 1, 2]"));
    }

    @Test
    void getOrderedMerge() throws Exception {

        when(arrayService.getOrderedMerge(new int[]{1,4}, 2, new int[]{3,2}, 2))
                .thenReturn(new int[]{1, 2, 3, 4});

        mockMvc.perform(get("/array/merge")
                .param("nums1", "1, 4")
                .param("nums2", "3, 2"))
                .andExpect(status().isOk())
                .andExpect(content().json("[1, 2, 3, 4]"));
    }

    @Test
    void removeValue() throws Exception {
        when(arrayService.removeValue(new int[]{1,2,3,2,5}, 2))
        .thenReturn(new int[]{1,3,5});

        mockMvc.perform(get("/array/remove")
                .param("nums", "1, 2, 3, 2, 5")
                .param("value", "2"))
                .andExpect(status().isOk())
                .andExpect(content().json("[1, 3, 5]"));
    }

}
