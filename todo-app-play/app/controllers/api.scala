package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import services.TodoServiceSimple

@Singleton
class TodoApiController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  
  def list() = Action { implicit request: Request[AnyContent] =>
    Ok(TodoServiceSimple.todos.toString())
  }
  
}