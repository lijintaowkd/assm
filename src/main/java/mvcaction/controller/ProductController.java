package mvcaction.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mvcaction.domain.Product;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ProductController {

    private static final Log logger = LogFactory
            .getLog(ProductController.class);

    @RequestMapping(value = "/product_input")
    public String inputProduct(Model model) {
        model.addAttribute("product", new Product());
        return "ProductForm";
    }

    @RequestMapping(value = "/product_save")
    public String saveProduct(HttpServletRequest servletRequest,@Valid @ModelAttribute Product product,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            logger.info("Code:" + fieldError.getCode() + ", object:"
                    + fieldError.getObjectName() + ", field:"
                    + fieldError.getField());
            return "ProductForm";
        }

        // save product here
        List<MultipartFile> files = product.getImages();

        List<String> fileNames = new ArrayList<String>();

        if (null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {

                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);

                File imageFile = new File(servletRequest.getServletContext()
                        .getRealPath("/image"), fileName);
                try {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        model.addAttribute("product", product);
        return "ProductDetails";
    }

    @RequestMapping(value="/download")
	 public ResponseEntity<byte[]> download(HttpServletRequest request,
			 @RequestParam("filename") String filename,
			 Model model)throws Exception{
		// 下载文件路径
		String path = request.getServletContext().getRealPath(
               "/image/");
		File file = new File(path+File.separator+ filename);
       HttpHeaders headers = new HttpHeaders();  
       // 下载显示的文件名，解决中文名称乱码问题  
       String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
       // 通知浏览器以attachment（下载方式）打开图片
       headers.setContentDispositionFormData("attachment", downloadFielName); 
       // application/octet-stream ： 二进制流数据（最常见的文件下载）。
       headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       // 201 HttpStatus.CREATED
       return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
               headers, HttpStatus.CREATED);  
	 }
}
