package com.todo.services.crypt;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class Exhange {
	public String exchange(String text){
		System.out.println(text);

		char[] arraytext = text.toCharArray();
		System.out.println(arraytext);
		int length = arraytext.length;
		
		for(int i = 0; i < length; i++) {
			switch (arraytext[i]) {
		    case 'a':
		    	arraytext[i] ='#';
		    	break;
		    case 'm':
		    	arraytext[i] = '$';
		    	break;
		    case 'e':
		    	arraytext[i] = '%';
		    	break;
		    case 'r':
		    	arraytext[i] = '&';
		    	break;
		    case 'i':
		    	arraytext[i] = '!';
		    	break;
		    case 'c':
		    	arraytext[i] = '*';
		    	break;
		    case 'A':
		    	arraytext[i] = '˜';
		    	break;
			}
			}
			
		String newText = Arrays.toString(arraytext).replace("[", "").replace("]", "").replace(", ", "");

		return newText;
	}

public String exchangeBack(String text){
		
	System.out.println(text);

	char[] arraytext = text.toCharArray();
	System.out.println(arraytext);
	int length = arraytext.length;
	
	for(int i = 0; i < length; i++) {
		switch (arraytext[i]) {
	    case '#':
	    	arraytext[i] ='a';
	    	break;
	    case '$':
	    	arraytext[i] = 'm';
	    	break;
	    case '%':
	    	arraytext[i] = 'e';
	    	break;
	    case '&':
	    	arraytext[i] = 'r';
	    	break;
	    case '!':
	    	arraytext[i] = 'i';
	    	break;
	    case '*':
	    	arraytext[i] = 'c';
	    	break;
	    case '˜':
	    	arraytext[i] = 'A';
	    	break;
		}
	}
	String newText = Arrays.toString(arraytext).replace("[", "").replace("]", "").replace(", ", "");

	return newText;
	}
}
