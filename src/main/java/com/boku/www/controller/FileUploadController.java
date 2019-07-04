package com.boku.www.controller;


import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.FileUtils;
import com.boku.www.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.OutputStream;

/**
 *@user 图片上传及显示
 */
@Controller
@CrossOrigin
public class FileUploadController {
    private final ResourceLoader resourceLoader;

    @Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path;




    /**
     * @return 跳转到文件上传页面
     */
    @RequestMapping("/Demo")
    public String index(){
        return "Dome";
    }
    /**
     *
     * @return 跳转到文件显示页面
     */
    /*@RequestMapping("/show")
    public String show(){
        return "show";
    }*/
    /**
     *
     * @param file 上传的文件
     * @return
     */
    @ResponseBody
    @RequestMapping("/fileUpload")
    public Result upload(@RequestParam("file")MultipartFile file ){
		try {
			//1定义要上传文件 的存放路径
			//String localPath="E:/image";
			//2获得文件名字
			String fileName=file.getOriginalFilename();
			//2上传失败提示
			//String warning="";
			String realPath = FileUtils.upload(file, path, fileName);
			/*if(StringUtils.isNotBlank(realPath)){
				//上传成功
				warning="上传成功";
			}else{
				warning="上传失败";
			}*/
			//System.out.println(warning);
			return new Result(true,realPath);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"上传失败");
		}
    }

    /**
     * 显示图片
     * @param fileName 文件名
     * @return
     */

    @RequestMapping("show")
    public /*ResponseEntity*/ void show(String fileName){
        /*try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path+ "/" + fileName));
            //return ResponseEntity.ok(resourceLoader.getResource("file:" + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }*/
		/*try {
			String patha = path + "/" + fileName;
			FileInputStream hFile;
			hFile = new FileInputStream(patha);
			int i = hFile.available();
			byte data[] = new byte[i];
			hFile.read(data);
			OutputStream toClient = resonse.
		}catch (Exception e) {
			e.printStackTrace();
		}*/
    }
}
