object question2 {
    def main(args: Array[String]): Unit = {
      val a = new Rational(5,4)
      val b = new Rational(5,7)
      val c = new Rational(3,5)

      val x = a-b-c

      println(x)
    }
  class Rational(n:Int, d:Int) {
    require(denom > 0, "Denominator must be greater than 0")
    def numer: Int = n
    def denom: Int = d
    def neg = new Rational(-this.numer, this.denom)
    def add(r:Rational) = new Rational(this.numer*r.denom + this.denom*r.numer, this.denom*r.denom)
    def -(r:Rational) = this.add(r.neg)

    override def toString: String = numer + "/" + denom
  }

}


