package springapp.src.controller;

import springapp.src.model.Medicine;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
    private Map<Integer, Medicine> pharmacySystem = new HashMap<>();
    private int nextMedicineId = 1;

    @PostMapping("/")
    public boolean addMedicine(@RequestBody Medicine medicine) {
        int medicineId = nextMedicineId++;
        medicine.setMedicineId(medicineId);
        pharmacySystem.put(medicineId, medicine);
        return true; // Successfully added
    }

    @PutMapping("/{medicineId}")
    public boolean updateMedicine(@PathVariable int medicineId, @RequestBody Medicine updatedMedicine) {
        if (pharmacySystem.containsKey(medicineId)) {
            updatedMedicine.setMedicineId(medicineId);
            pharmacySystem.put(medicineId, updatedMedicine);
            return true; // Successfully updated
        }
        return false; // Medicine not found
    }
}
