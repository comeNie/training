package com.comenie.springboot.swagger.store;

import com.comenie.springboot.swagger.Application;
import com.comenie.springboot.swagger.Swagger2Config;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Attributes;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.Placement;
import org.asciidoctor.SafeMode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.github.swagger2markup.Swagger2MarkupConverter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 波 on 2017/2/22.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class, Swagger2Config.class})
@AutoConfigureMockMvc
public class Swagger2MarkupTest {

    @Autowired
    private MockMvc mockMvc;
//
//    @Test
//    public void convertSwaggerToAsciiDoc2() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs")
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(Swagger2MarkupResultHandler.outputDirectory("src/docs/asciidoc/generated").build())
//                .andExpect(status().isOk());
//    }


    @Test
    public void convertSwaggerToAsciiDoc() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/v2/api-docs")
                .accept("application/json;charset=utf-8"))
                .andExpect(status().isOk())
                .andReturn();

        //文档输出目录
        String outputDirectory = "docs/restful/generated";
        Path outputDirectoryPath = Paths.get(outputDirectory);
        MockHttpServletResponse response = mvcResult.getResponse();
        String swaggerJson = response.getContentAsString();
//        swaggerJson = swaggerJson.replace("{\"status\":200,\"message\":\"\",\"data\":", "");
//        swaggerJson = swaggerJson.substring(0,swaggerJson.length()-1);
        Swagger2MarkupConverter.from(swaggerJson).build().toFolder(outputDirectoryPath);

        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        Attributes attributes = new Attributes();
        attributes.setCopyCss(true);
        attributes.setLinkCss(false);
        attributes.setSectNumLevels(3);
        attributes.setAnchors(true);
        attributes.setSectionNumbers(true);
        attributes.setHardbreaks(true);
        attributes.setTableOfContents(Placement.LEFT);
        attributes.setAttribute("generated", "generated");
        OptionsBuilder optionsBuilder = OptionsBuilder.options()
                .backend("html5")
                .docType("book")
                .eruby("")
                .inPlace(true)
                .safe(SafeMode.UNSAFE)
                .attributes(attributes);

//        asciidoctor.convertDirectory(new AsciiDocDirectoryWalker(outputDirectory),optionsBuilder.get());
        String asciiInputFile = "docs/restful/index.adoc";
        asciidoctor.convertFile(
                new File(asciiInputFile),
                optionsBuilder.get());

    }


//    @Test
//    public void createSpringfoxSwaggerJson() throws Exception{
//        String outputDir = System.getProperty("io.springfox.staticdocs.outputDir");
//        MvcResult mvcResult = this.mockMvc.perform(get("/v2/api-docs")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//        MockHttpServletResponse response = mvcResult.getResponse();
//        String swaggerJson = response.getContentAsString();
//        Files.createDirectories(Paths.get(outputDir));
//        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputDir, "swagger.json"), StandardCharsets.UTF_8)){
//            writer.write(swaggerJson);
//        }
//    }

//    @Test
//    public void convertSwaggerToMarkdown() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs")
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(Swagger2MarkupResultHandler.outputDirectory("src/docs/markdown/generated")
//                        .withMarkupLanguage(MarkupLanguage.MARKDOWN).build())
//                .andExpect(status().isOk());
//    }
}