package com.heyufei.user.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.heyufei.user.pojo.User;
import com.heyufei.user.service.UserService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import util.JwtUtil;
import util.OSS_Tencent;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器层
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private JwtUtil jwtUtil;
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",userService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",userService.findById(id));
	}

	/**
	 * 根据手机号查询
	 * @return
	 */
	@RequestMapping(value="/mobile/{mobile}",method= RequestMethod.GET)
	public Result findByMobile(@PathVariable String mobile){
		return new Result(true,StatusCode.OK,"查询成功",userService.findByMobile(mobile));
	}

	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<User> pageList = userService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<User>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",userService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param user
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody User user  ){
		userService.add(user);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody User user, @PathVariable int id ){
		user.setId(id);
		userService.update(user);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除用户，必须拥有管理员权限，否则不能删除。
	 * 	Token
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		Claims claims=(Claims) request.getAttribute("admin_claims");
		if(claims==null){
			return new Result(true,StatusCode.ACCESSRROR,"无权访问");
		}
		userService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}

	/**
	 * 发送短信验证码
	 * @param mobile 电话号码
	 */
	@RequestMapping(value="/sendsms/{mobile}",method=RequestMethod.POST)
	public Result sendsms(@PathVariable String mobile ){
		userService.sendSms(mobile);
		return new Result(true,StatusCode.OK,"发送成功");
	}
	/**
	 * 用户注册
	 */
	@RequestMapping(value="/register/{code}",method=RequestMethod.POST)
	public Result register( @RequestBody User user ,@PathVariable String code){
		userService.add(user,code);
		return new Result(true,StatusCode.OK,"注册成功");
	}

	/**
	 * 用户登陆
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Result login(@RequestBody Map<String,String> loginMap){
		User user = userService.findByMobileAndPassword(loginMap.get("mobile"),loginMap.get("password"));
		if(user!=null){
			String token = jwtUtil.createJWT(user.getMobile(),user.getNickname(), "user");
			Map<String,String> map=new HashMap<>();
			map.put("token",token);
			map.put("name",user.getNickname());//昵称
			map.put("avatar",user.getAvatar());//头像
			map.put("isvip",user.getIsVip()+"");//是否VIP

			return new Result(true,StatusCode.OK,"登陆成功",map);
		}else{
			return new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
		}
	}

	//采用file.transferTo 来保存上传的文件
	@RequestMapping("/uploadPic")
	@ResponseBody
	public String fileUpload1(@RequestParam("file") CommonsMultipartFile imgFile, HttpServletRequest request) throws IOException {
		//获取文件名 : file.getOriginalFilename();
		String uploadFileName = imgFile.getOriginalFilename();
		System.out.println("上传文件名 : "+uploadFileName);
		//如果文件名为空，直接回到首页！
		if ("".equals(uploadFileName)){
//            return "app/register.jsp";
			return null;
		}

		//上传路径保存设置
		String path = request.getServletContext().getRealPath("/upload");
		System.out.println("path----------------------"+path);
		//如果路径不存在，创建一个
		File realPath = new File(path);
		if (!realPath.exists()){
			realPath.mkdir();
		}
		System.out.println("上传文件保存地址："+realPath);

		OSS_Tencent oss = new OSS_Tencent();
		String picPath = realPath.getAbsolutePath() + "\\" + uploadFileName;
		String httpUrl = oss.upload(picPath, uploadFileName);
		System.out.println("httpUrl:  "+httpUrl);
		return httpUrl;
	}

	@RequestMapping("/uploadToFile")
	@ResponseBody
	public String uploadToUser(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String fileName = file.getOriginalFilename();
		String upload;
		System.out.println(fileName);
		if (fileName.indexOf("\\") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("\\"));
		}
		System.out.println(fileName);

		// 获取文件存放地址
		String filePath = request.getServletContext().getRealPath("/upload/");;
		File f = new File(filePath);
		if (!f.exists()) {
			f.mkdirs();// 不存在路径则进行创建
		}
		FileOutputStream out = null;
		try {
			// 重新自定义文件的名称
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String d = sdf.format(date);// 时间

			//名字
			fileName =  d + fileName.substring(fileName.indexOf('.'));
			filePath = filePath + fileName;
			System.out.println(filePath);
			out = new FileOutputStream(filePath);
			out.write(file.getBytes());
			out.flush();
			out.close();

			OSS_Tencent oss = new OSS_Tencent();
			upload = oss.upload(filePath,  fileName);
		} catch (Exception e) {
			return "error";
		}
		request.getSession().setAttribute("picUrl",upload);

		return upload; // 返回文件地址
	}
}
