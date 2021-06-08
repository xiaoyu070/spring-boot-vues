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

public class yan {
	/**
	 * 1代表注册2代表登录3代表改密码
	 * @author Administrator
	 *
	 */
	private static String phones;
	private static String codes;
	public String yanzheng(String phone,int i) {

		// TODO Auto-generated method stub
		String accessKeyId = "LTAI4GJzEsuZpaGDRimsLJob";
		String accessSecret ="lI9uFR6RD9AOLS6LRfbAvvjHFHZDRp";
		String code = vcode();
		System.out.println(code);
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2021-06-08");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName","ABC商城");
		this.phones=phone;
		this.codes=code;
        if(i==1) {
        	request.putQueryParameter("TemplateCode", "SMS_204107462");
        }
        if(i==2) {
        	request.putQueryParameter("TemplateCode", "SMS_218170894");
        }
        if(i==3) {
        	request.putQueryParameter("TemplateCode", "SMS_204112431");
        }
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
		return code;
	}
	/**	 *生成6位随机数验证码* @return	 */	
	public static String vcode(){		
		String vcode = "";        
		for (int i = 0; i < 6; i++) {            
			vcode = vcode + (int)(Math.random() * 9);        
			}        
		return vcode;
	}
	/**
	 * 手机号对应验证码
	 * @return
	 */
	public static Map<String,String> mm(){
		Map<String,String> map=new HashMap<>();
		map.put("phone",phones);
		map.put("code",codes);
		return map;
	}
}
