package com.changeEmail.util;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.context.support.AbstractMessageSource;

public class DatabaseMessageSource extends AbstractMessageSource{

	@Override
	protected MessageFormat resolveCode(String code, Locale locale) {
		// TODO Auto-generated method stub
		// 메세지 키가 greetin으로 들어왔을때 Locale이 kr 일때 -> "안녕하세요"
//		String message = translationRepository.findmessageByekeyAndLocale(code,locale);
		return null;
	}
	

}
