package ch.makery.calculator.view

import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import ch.makery.calculator.MainApp
import scalafx.scene.text.Text
import scalafx.scene.control.TextField
import scalafx.scene.image.{Image, ImageView}
import scala.math._
import scala.collection.mutable.ListBuffer


@sfxml
class MassController(
     private val backgroundCube: ImageView,
     private val backgroundPyramid: ImageView,
     private val backgroundSphere: ImageView,
     private val imageCube: ImageView,
     private val imagePyramid: ImageView,
     private val imageSphere: ImageView,
     private val textFieldL1: TextField,
     private val textFieldW1: TextField,
     private val textFieldH1: TextField,
     private val textFieldL2: TextField,
     private val textFieldW2: TextField,
     private val textFieldH2: TextField,
     private val textFieldR: TextField,
     private val textFieldA1: TextField,
     private val textFieldV1: TextField,
     private val textFieldA2: TextField,
     private val textFieldV2: TextField,
     private val textFieldA3: TextField,
     private val textFieldV3: TextField,
     private var value1: String,
     private var value2: String,
     private var value3: String,
     private var convertValue1: Double,
     private var convertValue2: Double,
     private var convertValue3: Double,
     private var slantHeight: Double,
     private var slantHeightString: String,
     private var area: Double,
     private var volume: Double,
     private var resultA: String,
     private var resultV: String
     ){
   
    backgroundCube.image = new Image("file:resources/images/white2.png")
    backgroundPyramid.image = new Image("file:resources/images/white2.png")
    backgroundSphere.image = new Image("file:resources/images/white2.png")
    imageCube.image = new Image("file:resources/images/cube.png")
    imagePyramid.image = new Image("file:resources/images/pyramid.png")
    imageSphere.image = new Image("file:resources/images/sphere.png")

    def handleBack(action: ActionEvent){
        MainApp.showGame()
    }

    def clearCubeTextField(action: ActionEvent){
       textFieldL1.setText("")
       textFieldW1.setText("")
       textFieldH1.setText("")
       textFieldA1.setText("")
       textFieldV1.setText("")
    }

    def clearPyramidTextField(action: ActionEvent){
       textFieldL2.setText("")
       textFieldW2.setText("")
       textFieldH2.setText("")
       textFieldA2.setText("")
       textFieldV2.setText("")
    }

     def clearSphereTextField(action: ActionEvent){
       textFieldR.setText("")
       textFieldA3.setText("")
       textFieldV3.setText("")
    }

     def calculateCube(action: ActionEvent){
        try{
            if (textFieldL1.getText() != "" && textFieldW1.getText() != "" && textFieldH1.getText() != ""){
                value1 = textFieldL1.getText()
                value2 = textFieldW1.getText()
                value3 = textFieldH1.getText()
                convertValue1 = value1.toDouble
                convertValue2 = value2.toDouble
                convertValue3 = value3.toDouble
                area = 2*((convertValue1*convertValue2)+(convertValue2*convertValue3)+(convertValue1*convertValue3))
                volume = convertValue1*convertValue2*convertValue3
                resultA = area.toString
                resultV = volume.toString
                textFieldA1.setText("")
                textFieldV1.setText("")
                textFieldA1.appendText("2 ((" + value1 + " * " + value2 + ") + (" + value2 + " * " + value3 + ") + (" + value1 + " * " + value3 + ")) = " + resultA)
                textFieldV1.appendText(value1+ " * " + value2 + " * " + value3 + " = " + resultV)
              
            }
           }catch{
              case x: NumberFormatException =>
              textFieldA1.setText("")
              textFieldV1.setText("")
              textFieldA1.appendText("Error")
              textFieldV1.appendText("Error")
             }
         
    }

    def calculatePyramid(action: ActionEvent){
        try{
            if (textFieldL2.getText() != "" && textFieldW2.getText() != "" && textFieldH2.getText() != ""){
                value1 = textFieldL2.getText()
                value2 = textFieldW2.getText()
                value3 = textFieldH2.getText()
                convertValue1 = value1.toDouble
                convertValue2 = value2.toDouble
                convertValue3 = value3.toDouble
                slantHeight = sqrt((convertValue2/2*convertValue2/2) + (convertValue3*convertValue3))
                area = (convertValue1*convertValue2) + (0.5*slantHeight*(convertValue2*4))
                volume = 0.333*(convertValue1*convertValue2)*convertValue3
                slantHeightString = slantHeight.toString
                resultA = area.toString
                resultV = volume.toString
                textFieldA2.setText("")
                textFieldV2.setText("")
                textFieldA2.appendText("("+ value1 + " * " + value2 + ") + " + "(0.5 * " + slantHeightString + "(" + value2 + " * 4)) = " + resultA)
                textFieldV2.appendText("1/3 * (" + value1 + " * " + value2 + ") * " + value3 + " = " + resultV)
            }
           }catch{
              case x: NumberFormatException =>
              textFieldA2.setText("")
              textFieldV2.setText("")
              textFieldA2.appendText("Error")
              textFieldV2.appendText("Error")
             }
    }

    def calculateSphere(action: ActionEvent){
        try{
            if (textFieldR.getText() != ""){
                value1 = textFieldR.getText()
                convertValue1 = value1.toDouble
                area = 4*3.142*convertValue1*convertValue1
                volume = 1.333*3.142*convertValue1*convertValue1*convertValue1
                resultA = area.toString
                resultV = volume.toString
                textFieldA3.setText("")
                textFieldV3.setText("")
                textFieldA3.appendText("4 * 3.142 * " + value1 + " * " + value1 + " = " + resultA)
                textFieldV3.appendText("4/3 * 3.142 * "+ value1 + " * " + value1 + " * " + value1 + "= " + resultV)
            }
         }catch{
              case x: NumberFormatException =>
              textFieldA3.setText("")
              textFieldV3.setText("")
              textFieldA3.appendText("Error")
              textFieldV3.appendText("Error")
             }

              
    }

     
}