package com.op.oops.innerclass;

import com.op.oops.innerclass.AllTypeInnerClasses.B;
import com.op.oops.innerclass.AllTypeInnerClasses.C;

public class InnerClassesTest
{

    public static void main(String[] str)
    {
        AllTypeInnerClasses allTypeInnerClasses = new AllTypeInnerClasses();

        // Non-Static Inner Class
        // Requires enclosing instance
        AllTypeInnerClasses.B obj1 = allTypeInnerClasses.new B();

        // Static Inner Class
        // No need for reference of object to the outer class
        AllTypeInnerClasses.C obj2 = new AllTypeInnerClasses.C();
        
        // can be used as a normal class
        C cobj = new C();
        cobj.print();
        
        B bobj = new AllTypeInnerClasses().new B();
        bobj.print();
        
        // private inner class not accessible from outside
       // BP bp_obj = new A().new BP();
    }
}