import static ratpack.groovy.Groovy.ratpack
import static ratpack.groovy.Groovy.groovyTemplate
import ratpack.groovy.templating.TemplatingModule

ratpack {
	bindings {
         add(TemplatingModule) { TemplatingModule.Config config -> config.staticallyCompile = true }
    }

    handlers {
        get() {
		
			Integer status = request.queryParams.status?.toInteger()
			def close = request.queryParams.close
			Integer sleep = request.queryParams.sleep?.toInteger()
			
			if(sleep){
				Thread.sleep(sleep)
			}
			
			if(close){
				response.headers.set('Content-Length',0)
				response.send()	
			}	
			
			if(status){
					response.headers.set 'Content-Type', 'application/json'
		            response.status(status)

					render "Status: ${status} ${sleep}"
			}else{
		       render groovyTemplate("main.html")
			}
			
			 assets "public"
		
        }
        
    }
}
/*
200 OK 201 Created 202 Accepted 203 Non-Authoritative Information 204 No Content 205 Reset Content 206 Partial Content 300 Multiple Choices 301 Moved Permanently 302 Found 303 See Other 304 Not Modified 305 Use Proxy 306 Unused 307 Temporary Redirect 308 Permanent Redirect 400 Bad Request 401 Unauthorized 402 Payment Required 403 Forbidden 404 Not Found 405 Method Not Allowed 406 Not Acceptable 407 Proxy Authentication Required 408 Request Timeout 409 Conflict 410 Gone 411 Length Required 412 Precondition Required 413 Request Entry Too Large 414 Request-URI Too Long 415 Unsupported Media Type 416 Requested Range Not Satisfiable 417 Expectation Failed 418 I'm a teapot 428 Precondition Required 429 Too Many Requests 431 Request Header Fields Too Large 500 Internal Server Error 501 Not Implemented 502 Bad Gateway 503 Service Unavailable 504 Gateway Timeout 505 HTTP Version Not Supported 511 Network Authentication Requi
*/