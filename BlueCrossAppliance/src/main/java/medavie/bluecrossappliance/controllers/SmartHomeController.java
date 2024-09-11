package medavie.bluecrossappliance.controllers;

import medavie.bluecrossappliance.entities.AirConditioner;
import medavie.bluecrossappliance.entities.Fan;
import medavie.bluecrossappliance.entities.Light;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.Month;

@Controller
public class SmartHomeController {

    private Light light = new Light(true);
    private Fan fan = new Fan(1);
    private AirConditioner airConditioner = new AirConditioner(true);

    @GetMapping("/light")
    public String light(Model model) {
        model.addAttribute("light", light);

        updateAppliances();

        return "light";
    }

    @PostMapping("/light")
    public String light(@RequestParam(name = "state") boolean state) {
        light.setState(state);
        return "redirect:/light";
    }

    @GetMapping("/fan")
    public String fan(Model model) {
        model.addAttribute("fan", fan);

        updateAppliances();

        return "fan";
    }

    @PostMapping("/fan")
    public String fan(@RequestParam(name = "speed") int speed) {
        fan.setSpeed(speed);
        return "redirect:/fan";
    }


    @GetMapping("/airConditioner")
    public String airConditioner(Model model) {
        model.addAttribute("airConditioner", airConditioner);

        updateAppliances();

        return "airConditioner";
    }

    @PostMapping("/airConditioner")
    public String airConditioner(@RequestParam(name = "state") boolean state) {
        airConditioner.setState(state);
        return "redirect:/airConditioner";
    }

    public void updateAppliances(){
        LocalDateTime now = LocalDateTime.now();

        if (now.getMonth() == Month.JANUARY && now.getDayOfMonth() == 1 && now.getHour() == 1 && now.getMinute() == 0) {
            fan.setSpeed(0);
            light.setState(false);
            airConditioner.setState(false);
        }
    }
}