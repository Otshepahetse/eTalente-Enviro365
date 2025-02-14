package com.enviro.assessment.grad001.TinteLehlohonolo.Control;

import com.enviro.assessment.grad001.TinteLehlohonolo.Model.RecyclingTip;
import com.enviro.assessment.grad001.TinteLehlohonolo.Service.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recyclingTips")
public class RecyclingTipController {
    @Autowired
    private RecyclingTipService recyclingTipService;

    @PostMapping("/{wasteCategoryId}")
    public RecyclingTip addRecyclingTip(@Valid @RequestBody RecyclingTip recyclingTip){
        return recyclingTipService.addRecyclingTip(recyclingTip);
    }

    @PutMapping("/{id}")
    public RecyclingTip updateRecyclingTip(@PathVariable Long id,@Valid @RequestBody RecyclingTip recyclingTip){
        return recyclingTipService.updateRecyclingTip(id,recyclingTip);
    }

    @GetMapping
    public List<RecyclingTip>getAllRecyclingTips(){
        return recyclingTipService.getAllRecyclingTips();
    }

    @GetMapping("/{id}")
    public RecyclingTip getRecyclingTipById(@PathVariable Long id){
        return recyclingTipService.getRecyclingTipById(id);
    }

    @GetMapping("wasteCategory/{wasteCategoryId}")
    public List<RecyclingTip> getRecyclingTipByWasteCategoryId(@PathVariable Long wasteCategoryId){
        return recyclingTipService.getRecyclingTipByWasteCategoryId(wasteCategoryId);
    }

    @DeleteMapping("/{id}")
    public void deleteRecyclingTip(Long id){
        recyclingTipService.deleteRecyclingTip(id);
    }
}
