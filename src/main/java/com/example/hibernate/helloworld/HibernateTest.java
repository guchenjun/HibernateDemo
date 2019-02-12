package com.example.hibernate.helloworld;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class HibernateTest {

	@Test
	public void test() {
		// 1.创建SessionFactory对象
		// 简单写法
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

//		// hibernate 5.x用法
//		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
//		Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder()
//				.applyImplicitNamingStrategy(ImplicitNamingStrategyComponentPathImpl.INSTANCE).build();
//		// 最后由这个metadata使用构建出sessionFactory
//		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//		
//		// hibernate 4.x 用法
//		Configuration configuration = new Configuration().configure();
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		// 2.创建一个Session对象
		Session session = sessionFactory.openSession();
		// 3.开启事物
		Transaction transaction = session.beginTransaction();
		// 4.执行保存操作
		News news = new News("Java", "ATGUIGU", new Date(new java.util.Date().getTime()));
		session.save(news);
		// 5.提交事物
		transaction.commit();
		// 6.关闭Session
		session.close();
		// 7.关闭SessionFactory对象
		sessionFactory.close();
	}
}
