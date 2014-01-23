package controllers

import play.api._
import play.api.libs.ws._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  // Example from http://www.playframework.com/documentation/2.2.x/ScalaWS
  def feedTitle(feedUrl: String) = Action.async {
    WS.url(feedUrl).get().map { response =>
      Ok("Feed title: " + (response.json \ "title").as[String])
    }
  }

}
