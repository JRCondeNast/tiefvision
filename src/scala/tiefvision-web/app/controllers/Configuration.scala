package controllers

import play.api.Play

object Configuration {

  lazy val HomeFolder = sys.env("TIEFVISION_HOME")
  val CropSize = 224
  val NumSamples = 5
  val BoundingBoxesFolder = "resources/bounding-boxes"
  val ScaledImagesFolder = "resources/bounding-boxes/scaled-images"
  val CropImagesFolder = "resources/bounding-boxes/crops"
  val CropImagesFolderV2 = "resources/bounding-boxes/cropsV2"
  val BackgroundCropImagesFolder = "resources/bounding-boxes/background-crops"
  val DbImagesFolder = "resources/dresses-db/master"
  val UploadedImagesFolder = "resources/dresses-db/uploaded/master"
  val scaleLevels = Seq(2, 3)
  val scaleLevelsV2 = Seq(1, 2)
  val testPercentage = 0.05
  
}
