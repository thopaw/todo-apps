package services

import model._
import scala.collection.mutable.MutableList

trait TodoService {
  
  def todos: List[Todo]
  
}

object TodoServiceSimple extends TodoService{
  
  val list = new  MutableList[Todo]()
  list += Todo("Simple Todo")
  
  def todos = list.toList
  
}