class WelcomeController < ApplicationController

  def index
      @videoss = HTTParty.get("http://ign-apis.herokuapp.com/videos?startIndex=#{params[:index]}&count=#{params[:count]}")
      @v = JSON.parse(@videoss.body)

      @articless = HTTParty.get("http://ign-apis.herokuapp.com/articles?startIndex=#{params[:index]}&count=#{params[:count]}")
      @a = JSON.parse(@articless.body)

  end

end
