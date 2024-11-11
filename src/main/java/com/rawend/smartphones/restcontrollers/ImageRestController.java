package com.rawend.smartphones.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.rawend.smartphones.entities.Image;
import com.rawend.smartphones.entities.Smartphone;
import com.rawend.smartphones.serevice.ImageService;
import com.rawend.smartphones.serevice.SmartphoneService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	 @Autowired
	 ImageService imageService ;
	 @Autowired
	 SmartphoneService smartphoneService;


	 @RequestMapping(value = "/upload" , method = RequestMethod.POST)
	 public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	 public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
	 return imageService.getImageDetails(id) ;
	 }
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException
	{
	 return imageService.getImage(id);
	 }


	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteImage(@PathVariable("id") Long id){
	 imageService.deleteImage(id);
	 }
	
	
	 @RequestMapping(value = "/update", method = RequestMethod.PUT)
	    public Image updateImage(@RequestParam("image") MultipartFile file) throws IOException {
	        return imageService.uplaodImage(file); // Correction ici
	    }

	 

	    @PostMapping(value = "/uploadImageSmar/{idSmar}")
	    public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("idSmar") Long idSmar) throws IOException {
	        return imageService.uplaodImageSmar(file, idSmar); // Correction ici
	    }
	@RequestMapping(value = "/getImagesSmar/{idSmar}" ,
	 method = RequestMethod.GET)
	 public List<Image> getImagesSmar(@PathVariable("idSmar") Long idSmar)
	throws IOException {
	 return imageService.getImagesParSmar(idSmar);
	 }

	 @RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
	 public void uploadImageFS(@RequestParam("image") MultipartFile 
			 file,@PathVariable("id") Long id) throws IOException {
		 Smartphone s = smartphoneService.getSmartphone(id);
		 s.setImagePath(id+".jpg");

		 Files.write(Paths.get(System.getProperty("user.home")+"/images/"+s.getImagePath())
				 , file.getBytes());
		 smartphoneService.saveSmartphone(s);

	 }
	 @RequestMapping(value = "/loadfromFS/{id}" , 
			 method = RequestMethod.GET,
			 produces = MediaType.IMAGE_JPEG_VALUE)
	 public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

		 Smartphone s = smartphoneService.getSmartphone(id);
		 return	 Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+s.getImagePath()));
	 }

	}