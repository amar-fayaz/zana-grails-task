package coding.challenge

import grails.converters.JSON
import grails.rest.RestfulController

class EntityRestController extends RestfulController{
    static responseFormats = ["json", "xml"]

    EntityRestController() {
        super(Entity)
    }

    @Override
    def getObjectToBind() {
        Map paramsObj = JSON.parse(request)
        if (paramsObj.contents) {
            for (int i=0; i<paramsObj.contents.size();i++){
                if (paramsObj.contents[i].title){
                    String titleVal = paramsObj.contents[i].title
                    paramsObj.contents[i] = Content.findByTitle(titleVal)
                    
                    if (!paramsObj.contents[i]){
                        response.sendError(400, "Cannot find entity with the title ${titleVal}")
                    }
                }
            }
        }
        paramsObj
    }
}
