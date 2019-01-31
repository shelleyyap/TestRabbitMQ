package Controller;

import Service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Producer producer;

    @RequestMapping(value="/test", method= RequestMethod.GET)
    @ResponseBody
    public void sendTestMessage() {
        producer.send();
    }
}
