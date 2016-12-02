package mraditya.design.patterns.chapter4

abstract class PrintData
abstract class PrintMaterial
abstract class PrintMedia

trait Printer {
  type Data <: PrintData
  type Material <: PrintMaterial
  type Media <: PrintMedia

  def print(data: Data, material: Material, media: Media) = s"Printing $data with $media on $material "

}

case class Paper() extends PrintMedia
case class Air() extends PrintMedia
case class Text() extends PrintData
case class Model() extends PrintData
case class Toner() extends PrintMaterial
case class Plastic() extends PrintMaterial

class LaserPrinter extends Printer {
  type Data = Text
  type Material = Toner
  type Media = Paper
}

class ThreeDPrinter extends Printer {
  type Data = Model
  type Material = Plastic
  type Media = Air
}