package smallchange;

import smallchange.oop.SmallChangeSysoop;

public class SmallChangeSysApp {
    public static void main(String[] args) {
      /*这里直接调用
      *smallchangesysoop对象，显示mainMenu即可，
      */
        SmallChangeSysoop smallChangeSysoop = new SmallChangeSysoop();
        smallChangeSysoop.mainMenu();
        //两行可以合一为new SmallChangeSysoop().mainMenu();功能是一样的
    }
}
