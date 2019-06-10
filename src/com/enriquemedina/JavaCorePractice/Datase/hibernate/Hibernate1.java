package com.enriquemedina.JavaCorePractice.Datase.hibernate;

public class Hibernate1 {
	public static void main(String[] args) {
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		try {
			Message msg = (Message)session.get(Message.class,2L);
			msg.setText("Hello automatic checking");
			
			txn.commit();
		}catch(Exception e){
			if(txn != null) txn.rollback();
			e.printStackTrace();
		}finally {
			if(session != null) {session.close();}
		}*/
	}

}
