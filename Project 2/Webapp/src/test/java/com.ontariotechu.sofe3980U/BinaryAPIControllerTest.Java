package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }
	@Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    //Test Case 1
    @Test
    public void add3() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","1111").param("operand2","1111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(011110))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }
     //Test Case 2
     @Test
     public void add4() throws Exception {
         this.mvc.perform(get("/add_json").param("operand1","1011").param("operand2","111"))//.andDo(print())
             .andExpect(status().isOk())
             .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1011))
             .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(111))
             .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(010010))
             .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
 
 }

  //Test Case 3
  @Test
  public void add5() throws Exception {
      this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1011"))//.andDo(print())
          .andExpect(status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
          .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1011))
          .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(010010))
          .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));

}

///*Test The and functions with two binary numbers
@Test
public void AND1() throws Exception {
    this.mvc.perform(get("/bitwiseAND_json").param("operand1","1101").param("operand2","1001"))//.andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1101))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1001))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1001))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("bitwiseAND"));

}

/*Test The and functions with two binary numbers, the length of the first argument is greater than the second
    */
@Test
public void AND2() throws Exception {
    this.mvc.perform(get("/bitwiseAND_json").param("operand1","111011").param("operand2","101"))//.andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111011))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("bitwiseAND"));

}
/*Test The and functions with two binary numbers, the length of the first argument is less than the second
    */
@Test
public void AND3() throws Exception {
    this.mvc.perform(get("/bitwiseAND_json").param("operand1","101").param("operand2","111011"))//.andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(101))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(111011))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("bitwiseAND"));

}

///*Test The or functions with two binary numbers
@Test
public void OR1() throws Exception {
    this.mvc.perform(get("/bitwiseOR_json").param("operand1","1101").param("operand2","1001"))//.andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1101))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1001))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1101))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("bitwiseOR"));

}

/*Test The OR functions with two binary numbers, the length of the first argument is greater than the second
    */
@Test
public void OR2() throws Exception {
    this.mvc.perform(get("/bitwiseOR_json").param("operand1","111011").param("operand2","101"))//.andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111011))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(111111))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("bitwiseOR"));

}
/*Test The OR functions with two binary numbers, the length of the first argument is less than the second
    */
@Test
public void OR3() throws Exception {
    this.mvc.perform(get("/bitwiseOR_json").param("operand1","101").param("operand2","111011"))//.andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(101))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(111011))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(111111))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("bitwiseOR"));

}

///*Test The MULTIPLY functions with two binary numbers
@Test
public void MULTIPLY1() throws Exception {
    this.mvc.perform(get("/bitwiseMULTIPLY_json").param("operand1","1101").param("operand2","1001"))//.andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1101))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1001))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1110101))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("bitwiseMULTIPLY"));

}

/*Test The MULTIPLY functions with two binary numbers, the length of the first argument is greater than the second
    */
@Test
public void MULTIPLY2() throws Exception {
    this.mvc.perform(get("/bitwiseMULTIPLY_json").param("operand1","111011").param("operand2","101"))//.andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111011))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(100100111))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("bitwiseMULTIPLY"));

}
/*Test The MULTIPLY functions with two binary numbers, the length of the first argument is less than the second
    */
@Test
public void MULTIPLY3() throws Exception {
    this.mvc.perform(get("/bitwiseMULTIPLY_json").param("operand1","101").param("operand2","111011"))//.andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(101))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(111011))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(100100111))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("bitwiseMULTIPLY"));

}

}