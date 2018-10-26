package com.todo.services.crypt;

import org.springframework.stereotype.Service;

@Service
public class Encrypt {

	public String crypt(String text, int shift){
		if(shift>26) {
			shift = shift%26;
		}
		else if(shift<0) {
			shift = (shift%26)+26;
		}
		String newText = "";
		int length = text.length();
		for(int i = 0; i<length; i++) {
			char ch = text.charAt(i);
			if(Character.isLetter(ch)){
				if(Character.isLowerCase(ch)) {
					char c = (char)(ch+shift);
					if(c>'z') {
						newText += (char)(ch - (26-shift));
					}
					else {
						newText += c;
					}
				}else if(Character.isUpperCase(ch)){
					char c = (char)(ch+shift);
					if(c>'Z') {
						newText += (char)(ch - (26-shift));
					}
					else {
						newText += c;
					}
				}
			}else{
			newText += ch;
		}
			}
		return newText;
	}
	
	public String decrypt(String text, int shift){
		if(shift>26) {
			shift = shift%26;
		}
		else if(shift<0) {
			shift = (shift%26)+26;
		}
		String newText = "";
		int length = text.length();
		for(int i = 0; i<length; i++) {
			char ch = text.charAt(i);
			if(Character.isLetter(ch)){
				if(Character.isLowerCase(ch)) {
					char c = (char)(ch-shift);
					if(c<'a') {
						newText += (char)(ch + (26-shift));
					}
					else {
						newText += c;
					}
				}else if(Character.isUpperCase(ch)){
					char c = (char)(ch+shift);
					if(c<'A') {
						newText += (char)(ch + (26-shift));
					}
					else {
						newText += c;
					}
				}
			}else{
			newText += ch;
		}
			}
		return newText;
	}
}

