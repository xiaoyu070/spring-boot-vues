package com.trkj.projects.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class yan {
	/**
	 * 1代表注册2代表登录3代表改密码
	 * @author Administrator
	 *
	 */

	Map<String,String> map=new HashMap<>();
	public String yanzheng(String phone,int i) {
			//LTAI4Fgzwq2Q6LfhWhpRJQL8
			String accessKeyId=null;
			//kw2ekRkeTrncBBq8ZVplflZq19QTls
			String accessSecret=null;
			String SignName="星际进销存";
			DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessSecret);
			IAcsClient client = new DefaultAcsClient(profile);
			CommonRequest request=new CommonRequest();
			request.setSysMethod(MethodType.POST);
			request.setSysDomain("dysmsapi.aliyuncs.com");
			request.setSysVersion("2017-05-25");
			request.setSysAction("SendSms");
			request.putQueryParameter("PhoneNumbers", phone);
			request.putQueryParameter("SignName",SignName);
			if (i==1){
				request.putQueryParameter("TemplateCode","SMS_199600531");//注册
			}else if(i==2){
				request.putQueryParameter("TemplateCode","SMS_199771688");//快速登录
			}else if(i==3){
				request.putQueryParameter("TemplateCode","SMS_199791543");//修改手机号
			}else if(i==4){
				request.putQueryParameter("TemplateCode","SMS_201651159");//修改密码
			}
			String code=smsCode(phone);
			map.put(phone,code);
			request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
			trydel(map,phone);
			try {
				CommonResponse response=client.getCommonResponse(request);
				System.out.println(response.getData());
			} catch (ClientException e) {
				//e.printStackTrace();
			}
			return code;
	}
	//创建验证码
	public static String smsCode(String phone){
		String random=(int)((Math.random()*9+1)*100000)+"";
		System.out.print("验证码:"+random);
		return random;
	}
	public static void trydel(Map map,String phone) {
		System.out.println("当前所有有效验证码" + map);
		System.out.println("键："+map.get(phone));
		//1分钟后删除验证码
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println(map.get(phone) + "------验证码已失效");
				map.remove(phone);
				timer.cancel();
			}
		}, 60 * 1000);
	}
	/**	 *生成6位随机数验证码* @return	 */	
	public static String vcode(){		
		String vcode = "";        
		for (int i = 0; i < 6; i++) {            
			vcode = vcode + (int)(Math.random() * 9);        
			}        
		return vcode;
	}
	//判断验证码是否过期 以及是否有效
	public String isphonecode(String phone) {
		if (map.size() >0 && map.containsKey(phone)){
			return map.get(phone);
		}else {
			return null;
		}
	}
}
