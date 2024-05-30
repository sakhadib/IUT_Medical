package Utility;

import java.util.*;

public class TestHelper {

    public static String[] testNames = {
            "Complete Blood Count (CBC)", "Diagnose anemia, infection, and other disorders",
            "Lipid Panel", "Assess risk of cardiovascular disease",
            "Basic Metabolic Panel (BMP)", "Check kidney function, blood sugar, and electrolyte levels",
            "Comprehensive Metabolic Panel (CMP)", "Evaluate liver and kidney function, blood sugar, and protein levels",
            "Liver Function Test (LFT)", "Assess liver health and diagnose liver diseases",
            "Thyroid Function Test", "Diagnose thyroid disorders like hypothyroidism and hyperthyroidism",
            "Hemoglobin A1C", "Monitor and diagnose diabetes",
            "Urinalysis", "Detect urinary tract infections, kidney disease, and diabetes",
            "Prothrombin Time (PT/INR)", "Evaluate blood clotting and diagnose bleeding disorders",
            "C-reactive Protein (CRP)", "Detect inflammation and monitor treatment of inflammatory diseases",
            "Erythrocyte Sedimentation Rate (ESR)", "Detect inflammation associated with infections, cancers, and autoimmune diseases",
            "Vitamin D Test", "Assess vitamin D deficiency",
            "Magnetic Resonance Imaging (MRI)", "Diagnose neurological, musculoskeletal, and cardiovascular conditions",
            "Computed Tomography (CT) Scan", "Diagnose internal injuries, infections, and cancers",
            "Electrocardiogram (ECG/EKG)", "Diagnose heart conditions like arrhythmias and myocardial infarctions",
            "Mammography", "Screen for breast cancer",
            "Pap Smear", "Detect cervical cancer and precancerous conditions",
            "Colonoscopy", "Screen for colorectal cancer and investigate intestinal symptoms",
            "Bone Density Scan (DEXA)", "Diagnose osteoporosis and assess fracture risk",
            "Pulmonary Function Test (PFT)", "Evaluate lung function and diagnose respiratory disorders",
            "Blood Glucose Test", "Monitor and diagnose diabetes",
            "Serum Electrolytes", "Assess electrolyte imbalances",
            "Iron Studies", "Diagnose anemia and iron overload",
            "B-type Natriuretic Peptide (BNP)", "Diagnose heart failure",
            "Troponin", "Diagnose heart attacks",
            "Creatine Kinase (CK)", "Diagnose muscle damage, including heart muscle",
            "Blood Urea Nitrogen (BUN)", "Evaluate kidney function",
            "Urine Culture", "Diagnose urinary tract infections",
            "Stool Culture", "Diagnose gastrointestinal infections",
            "Hepatitis Panel", "Diagnose hepatitis A, B, and C infections",
            "HIV Test", "Diagnose HIV infection",
            "Syphilis Test (RPR)", "Diagnose syphilis infection",
            "Chlamydia Test", "Diagnose chlamydia infection",
            "Gonorrhea Test", "Diagnose gonorrhea infection",
            "Herpes Simplex Virus (HSV) Test", "Diagnose herpes infection",
            "Human Papillomavirus (HPV) Test", "Diagnose HPV infection and assess risk for cervical cancer",
            "Prostate-Specific Antigen (PSA)", "Screen for prostate cancer",
            "Celiac Disease Test", "Diagnose celiac disease",
            "Helicobacter pylori (H. pylori) Test", "Diagnose H. pylori infection in the stomach",
            "Lactose Intolerance Test", "Diagnose lactose intolerance",
            "Genetic Testing", "Identify genetic disorders and carrier status",
            "Allergy Testing", "Identify allergic reactions to various substances",
            "Rheumatoid Factor (RF)", "Diagnose rheumatoid arthritis",
            "Anti-Nuclear Antibodies (ANA)", "Diagnose autoimmune diseases",
            "D-dimer", "Diagnose blood clotting disorders like DVT and PE",
            "Ferritin", "Evaluate iron stores in the body",
            "Cortisol", "Assess adrenal gland function",
            "Testosterone", "Evaluate male hormone levels",
            "Estradiol", "Evaluate female hormone levels",
            "Progesterone", "Evaluate female hormone levels",
            "Follicle-Stimulating Hormone (FSH)", "Evaluate reproductive function",
            "Luteinizing Hormone (LH)", "Evaluate reproductive function",
            "Parathyroid Hormone (PTH)", "Assess parathyroid gland function",
            "Growth Hormone (GH)", "Evaluate growth disorders",
            "Insulin", "Assess insulin levels and diagnose insulin resistance",
            "Blood Gases", "Assess lung function and blood acid-base balance",
            "Carcinoembryonic Antigen (CEA)", "Monitor cancer treatment, especially for colon cancer",
            "CA-125", "Monitor ovarian cancer treatment",
            "Alpha-Fetoprotein (AFP)", "Screen for liver cancer",
            "Procalcitonin", "Diagnose bacterial infections and sepsis",
            "Amylase", "Diagnose pancreatic disorders",
            "Lipase", "Diagnose pancreatic disorders",
            "Thyroglobulin", "Monitor thyroid cancer treatment",
            "Thyroid-Stimulating Immunoglobulin (TSI)", "Diagnose Graves' disease",
            "Antithyroid Peroxidase Antibodies (TPO)", "Diagnose Hashimoto's thyroiditis",
            "Erythropoietin", "Evaluate bone marrow function",
            "Vitamin B12", "Diagnose vitamin B12 deficiency",
            "Folate", "Diagnose folate deficiency",
            "Zinc", "Assess zinc deficiency",
            "Copper", "Assess copper deficiency or excess",
            "Lead", "Assess lead poisoning",
            "Mercury", "Assess mercury poisoning",
            "Arsenic", "Assess arsenic poisoning",
            "Lyme Disease Test", "Diagnose Lyme disease",
            "Mononucleosis Test", "Diagnose mononucleosis",
            "Cytomegalovirus (CMV) Test", "Diagnose CMV infection",
            "Epstein-Barr Virus (EBV) Test", "Diagnose EBV infection"
    };

    public static List<String> getRandomNames(int n) {
        List<String> names = new ArrayList<String>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int index = rand.nextInt(testNames.length);
            names.add(testNames[index]);
        }
        return names;
    }

}
