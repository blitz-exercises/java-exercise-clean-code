package nl.blitz.cleancode.report;

import java.util.List;

class ReportGenerator {
    public String generate(int type, List<Object> data, boolean includeDetails, boolean includeCharts, boolean includeSummary) {
        String report = "";
        
        // generate report based on type
        if (type == 1) {
            report = generateSalesReport(data, includeDetails, includeCharts, includeSummary);
        } else if (type == 2) {
            report = generateInventoryReport(data, includeDetails, includeCharts, includeSummary);
        } else if (type == 3) {
            report = generateCustomerReport(data, includeDetails, includeCharts, includeSummary);
        } else {
            report = "Unknown report type";
        }
        
        return report;
    }

    private String generateSalesReport(List<Object> data, boolean details, boolean charts, boolean summary) {
        String result = "Sales Report\n";
        // process sales data
        for (Object item : data) {
            result += item.toString() + "\n";
        }
        if (details) {
            result += "Details included\n";
        }
        if (charts) {
            result += "Charts included\n";
        }
        if (summary) {
            result += "Summary included\n";
        }
        return result;
    }

    private String generateInventoryReport(List<Object> data, boolean details, boolean charts, boolean summary) {
        String result = "Inventory Report\n";
        // similar code duplicated
        for (Object item : data) {
            result += item.toString() + "\n";
        }
        if (details) {
            result += "Details included\n";
        }
        if (charts) {
            result += "Charts included\n";
        }
        if (summary) {
            result += "Summary included\n";
        }
        return result;
    }

    private String generateCustomerReport(List<Object> data, boolean details, boolean charts, boolean summary) {
        String result = "Customer Report\n";
        // same code again
        for (Object item : data) {
            result += item.toString() + "\n";
        }
        if (details) {
            result += "Details included\n";
        }
        if (charts) {
            result += "Charts included\n";
        }
        if (summary) {
            result += "Summary included\n";
        }
        return result;
    }
}

