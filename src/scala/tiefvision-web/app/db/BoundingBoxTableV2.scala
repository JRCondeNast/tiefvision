/**
  * Copyright (C) 2016 Pau Carré Cardona - All Rights Reserved
  * You may use, distribute and modify this code under the
  * terms of the Apache License v2.0 (http://www.apache.org/licenses/LICENSE-2.0.txt).
  */
package db

import core.Crop
import db.Dataset._
import slick.driver.PostgresDriver.api._


class BoundingBoxTableV2(tag: Tag) extends Table[BoundingBoxV2](tag, "BOUNDING_BOX_Info") {

  def name = column[String]("FILE_NAME")

  def top = column[Int]("TOP")

  def left = column[Int]("LEFT")

  def bottom = column[Int]("BOTTOM")

  def right = column[Int]("RIGHT")

  def width = column[Int]("WIDTH")

  def height = column[Int]("HEIGHT")

  def dataset = column[Dataset]("DATASET")

  def object_class = column[String]("CLASS")

  def prob = column[Double]("Prob")

  def pk = primaryKey("pk_a", (name, top, left, bottom, right, object_class))

  def * = (name, top, left, bottom, right, width, height, dataset, object_class, prob) <> (BoundingBoxV2.tupled, BoundingBoxV2.unapply)

}

case class BoundingBoxV2(name: String, top: Int,
                         left: Int, bottom: Int, right: Int, width: Int, height: Int, dataset: Dataset, object_class: String, prob: Double) {

  def toCrop = Crop(left, right, top, bottom)

  def div(denominator: Double) = BoundingBoxV2(
    name = name,
    top = (top.toDouble / denominator).ceil.toInt,
    left = (left.toDouble / denominator).ceil.toInt,
    bottom = (bottom.toDouble / denominator).ceil.toInt,
    right = (right.toDouble / denominator).ceil.toInt,
    width = (width.toDouble / denominator).ceil.toInt,
    height = (height.toDouble / denominator).ceil.toInt,
    dataset = dataset,
    object_class = object_class,
    prob = prob)
}
