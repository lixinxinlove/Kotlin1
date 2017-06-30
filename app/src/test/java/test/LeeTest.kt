package test

import org.junit.Test

/**
 * Created by android on 2017/6/10.
 */

class LeeTest {

    /*  @Test
      fun addition_isCorrect() {
          var user = User("lee", 22)
          print(user.name)
      }

      @Test
      fun addTest() {
          var s = DateTimeUtil.add(1, 2)
          print(s)
      }

      @Test
      fun getLengthTest() {
          var l = DateTimeUtil.getLength("1234567890")
          print(l)
      }

      @Test
      fun forTest() {
          for (x in 1..10) {
              print(x)
          }
      }

      @Test
      fun whenTest() {
          var x: Int = 1
          when (x) {
              1 -> print("x$x")
              2 -> print("x$x")
          }
      }*/

//    @Test
//    fun interfaceTest() {
//
//        var stu1 = Student<String>("lixinxin", 18, true)
//
//        stu1.t = "10000"
//
//        stu1.eat()
//        stu1.see()
//        stu1.run()
//
//        stu1.left()
//
//    }


    @Test
    fun kz() {

        fun MutableList<Int>.swap(x: Int, y: Int) {
            val temp = this[x]
            this[x] = this[y]
            this[y] = temp
        }

        val l = mutableListOf(1, 2, 3)
        l.swap(0, 1)
        l.forEach { x-> print(x) }

    }

    fun sx(){
        for (n in 100..999) {
            val a = n / 100
            val b = n % 100 / 10
            val c = n % 10
            if (Math.pow(a.toDouble(), 3.0) + Math.pow(b.toDouble(), 3.0) + Math.pow(c.toDouble(), 3.0) == n.toDouble()) {
                println(n)
            }
        }
    }



}
