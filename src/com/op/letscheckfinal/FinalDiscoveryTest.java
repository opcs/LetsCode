package com.op.letscheckfinal;

public class FinalDiscoveryTest {

	public static void main(String[] args) {
		Student stu=new Student("op", 1111L);
		stu.setName("opcs");
		System.out.println(stu);

		FinalDiscovery discovery=new FinalDiscovery();
		final Student stud_f = discovery.getStud_f();
		//stud_f=stu;								// can not reassign/change reference Id
		
		stud_f.setName("fchanged");					//final reference state can be changed
		System.out.println(stud_f);
		
	}

}
