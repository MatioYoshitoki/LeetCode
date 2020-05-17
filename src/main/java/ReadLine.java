public class ReadLine {
    
    //已知函数
    static int count =0;
    private String recv(){
        switch (++count){
            case 1: return "123\n45\n6789";
            case 2:return "abc";
            case 3:return "de\n";
        }
        return "\n";
    }
  
  /*
  请观察以上已知函数，每次调用返回一段字符，其中有零、一或多个换行符；
  请写出下面的read（）函数，要求使用上述的recv（）来实现，每次调用read（）时返回一行；
  在这个范例程序里，要求打印出来三行：
  123
  45
  6789abcde
  */
  public static void main(String[] args) {
      ReadLine rl = new ReadLine();
      String one = rl.read();
      System.out.print(one);
      System.out.print(rl.read());
      System.out.print(rl.read());
  }

  StringBuffer buffer = new StringBuffer();
  //TODO 补充代码
  public String read(){
      buffer.append(recv());
      int index = buffer.indexOf("\n");
      String result = buffer.substring(0, index+1);
      buffer.delete(0, index+1);
      return result;
  }  
}