package com.apex.client;

import java.nio.file.FileSystem;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.apex.server.BasicCal;
import com.apex.server.Calc;

public class Client {
	    Calc cal = null;
	public Calc getCal() {
			return cal;
		}

		public void setCal(Calc cal) {
			this.cal = cal;
		}

	public static void main(String[] args) {
		Client client = (Client)getBeanFactory().getBean("client");
		client.calOperations();
	}

	public void calOperations() {
		
		int var1 = cal.add(4, 12);
		int var2 = cal.sub(24, 12);
		int var3 = cal.div(14, 7);
		int var4 = cal.mul(4, 12);

		System.out.println(" The sum is: " + var1);
		System.out.println(" The sub is: " + var2);
		System.out.println(" The div is: " + var3);
		System.out.println(" The mul is: " + var4);
	}
	public static BeanFactory getBeanFactory() {
		Resource resource =	new FileSystemResource ("beans.xml");
		XmlBeanFactory beanFactory=new XmlBeanFactory(resource);
		return beanFactory;
	}
}
