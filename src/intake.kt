import javax.swing.JFrame

fun main(args: Array<String>)
{
    // SRL のホームページから計算式を拝借: http://www.srl.info/srlinfo/salt/
    val f = JFrame("推定塩分摂取量計算機")
    val g = gui()
    f.contentPane = g.panel1
    f.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    f.setSize(400, 300)
    f.isResizable = false
    f.setLocationRelativeTo(null)
    f.isVisible = true
    g.calcbutton.addActionListener {
        val weight = g.weightfield.text.toFloat()
        val height = g.heightfield.text.toFloat()
        val na = g.nafield.text.toFloat()
        val cr = g.crfield.text.toFloat()
        val age = g.agefield.text.toInt()
        val ucr = weight*14.89+height*16.14-age*2.043-2244.45
        val una = 21.98* Math.pow(na / cr /10* ucr, 0.392)
        val nacl = una/17.0
        g.outputLabel.text = String.format("%3.1f", nacl)
    }
}
