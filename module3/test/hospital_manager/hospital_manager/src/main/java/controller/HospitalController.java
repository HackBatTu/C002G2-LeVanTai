package controller;

import model.MedicalRecord;
import model.Patient;
import service.IMedicalRecordService;
import service.IPatientService;
import service.impl.MedicalRecordService;
import service.impl.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "HospitalController", value = "/home")
public class HospitalController extends HttpServlet {
    private IMedicalRecordService medicalRecordService = new MedicalRecordService();
    private IPatientService patientService = new PatientService();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                deleteMedicalRecord(request, response);
                break;
            default:
                showListMedicalRecords(request, response);
                break;
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idEdit = request.getParameter("idEdit");
        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecordForEdit(idEdit);
        List<Patient> patients = patientService.getAllPatients();
        request.setAttribute("listPatients", patients);
        request.setAttribute("medicalRecord", medicalRecord);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    private void deleteMedicalRecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idDelete = request.getParameter("idDelete");
        medicalRecordService.deleteMedicalRecord(idDelete);
        response.sendRedirect("home");
    }

    private void showListMedicalRecords(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MedicalRecord> medicalRecords = medicalRecordService.getAllMedicalRecords();
        List<Patient> patients = patientService.getAllPatients();
        request.setAttribute("listMedicalRecords", medicalRecords);
        request.setAttribute("listPatients", patients);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                String medicalRecordId = request.getParameter("idEdit");
                String patientId = request.getParameter("patientId");
                String patientName = request.getParameter("patientName");
                String hospitalizedDayTemp = request.getParameter("hospitalizedDay");
                String errHospitalizedDay = null;
                Date hospitalizedDay = null;
                try {
                    hospitalizedDay = Date.valueOf(hospitalizedDayTemp);
                } catch (IllegalArgumentException e) {
                    errHospitalizedDay = "Vui lòng nhập đúng định dạng ngày (dd/MM/yyyy)";
                } catch (Exception e) {
                    errHospitalizedDay = "Vui lòng nhập đúng định dạng ngày (dd/MM/yyyy)";
                }
                String dischargeDayTemp = request.getParameter("dischargeDay");
                String errDischargeDay = null;
                Date dischargeDay = null;
                try {
                    dischargeDay = Date.valueOf(dischargeDayTemp);
                } catch (IllegalArgumentException e) {
                    errDischargeDay = "Sai định dạng ngày (dd/MM/yyyy)";
                } catch (Exception e) {
                    errDischargeDay = "Sai định dạng ngày (dd/MM/yyyy)";
                }
                String hospitalizedReason = request.getParameter("hospitalizedReason");
                MedicalRecord medicalRecord = new MedicalRecord(medicalRecordId, patientId, hospitalizedDay, dischargeDay, hospitalizedReason);

                Map<String, String> errMedicalRecord = new HashMap<>();

                Map<String, String> errMap = new HashMap<>();
                Map<String, String> errPatient = new HashMap<>();
                if (errHospitalizedDay != null) {
                    errMap.put("errHospitalizedDay", errHospitalizedDay);
                } else {
                    errMedicalRecord = medicalRecordService.editMedicalRecord(medicalRecord);
                }
                if (errDischargeDay != null) {
                    errMap.put("errDischargeDay", errDischargeDay);
                } else {
                    errPatient = patientService.editPatient(medicalRecordId, patientId, patientName);
                }
                if (!errMedicalRecord.isEmpty()) {
                    errMap.putAll(errMedicalRecord);
                }
                if (!errPatient.isEmpty()) {
                    errMap.putAll(errPatient);
                }

                if (errMap.isEmpty()) {
                    response.sendRedirect("home");
                } else {
                    List<Patient> patients = patientService.getAllPatients();
                    for (Patient patient: patients) {
                        if (patient.getPatientId().equals(medicalRecord.getPatientId())) {
                            patient.setPatientName(patientName);
                            break;
                        }
                    }
                    request.setAttribute("listPatients", patients);
                    request.setAttribute("medicalRecord", medicalRecord);
                    request.setAttribute("errMap", errMap);
                    request.getRequestDispatcher("edit.jsp").forward(request, response);
                }
                break;
            default:
                showListMedicalRecords(request, response);
                break;
        }
    }
}
