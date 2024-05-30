package Utility;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
public class MedsHelper {
    public static String[] medsNames = {
            "Zynolax","Vitrozep","Neotraz","Dexicor","Nuvolax","Zeracil","Epicoril","Zybaril","Fluvent","Lunacor",
            "Cynotrex", "Xylocent", "Vivastat", "Hexaline", "Ombrosin", "Zymerol", "Aquilin", "Novacil", "Rivacor",
            "Zymeril", "Solucor", "Exodex", "Truvicor", "Nexacil", "Vitroxin", "Aerorin", "Hydrozil", "Xylodex",
            "Zyloxon", "Fluxitol", "Evidex", "Glozolin", "Nexacor", "Dermacil", "Intrazep", "Vibroxil", "Lunovil",
            "Xytrin", "Epicilin", "Moxacil", "Zymerin", "Soluvic", "Lexotin", "Aerozep", "Truvacor", "Zolaxin",
            "Nuvocor", "Hexalax", "Zolaxin", "Ombrozil", "Rivarin", "Zymetrix", "Vitroxon", "Xylocor", "Aerofin",
            "Neurodex", "Glozolax", "Dexicent", "Nexavil", "Vivazep", "Evidex", "Cynodex", "Zyloril", "Exacor",
            "Vitracil", "Lunovil", "Zymatol", "Aerovin", "Rivatol","Nuvatol", "Hydrovin", "Fluxatol", "Epicent",
            "Cynovil", "Xylotol", "Nexalor", "Zymazep", "Vivaril", "Lexonil", "Dexatol",
            "Soluxin", "Truvatol", "Novazep"
    };

    public static String[] generic = {
            "Azelastine", "Brompheniramine", "Chlorpheniramine", "Desloratadine", "Ebastine",
            "Fexofenadine", "Guaifenesin", "Hydroxyzine", "Ipratropium", "Ketotifen", "Levocetirizine",
            "Montelukast", "Nedocromil", "Olopatadine", "Pseudoephedrine", "Quinidine", "Rupatadine", "Salmeterol",
            "Terbutaline", "Umeclidinium", "Verapamil", "Warfarin", "Xylometazoline", "Yohimbine", "Zafirlukast",
            "Allopurinol", "Bupropion", "Captopril", "Duloxetine", "Enalapril", "Furosemide", "Gabapentin",
            "Hydrochlorothiazide", "Indapamide", "Jenner's Vaccine", "Ketoconazole", "Lisinopril", "Metformin",
            "Nifedipine", "Omeprazole", "Paracetamol", "Quetiapine", "Risperidone", "Simvastatin", "Telmisartan",
            "Ursodeoxycholic acid", "Venlafaxine", "Warfarin", "Xanax", "Yohimbine", "Zafirlukast",
            "Atorvastatin", "Budesonide", "Cetirizine", "Dexamethasone", "Esomeprazole", "Fluticasone", "Glibenclamide",
            "Hydrocortisone", "Ibuprofen", "Jujuboside", "Ketorolac", "Loperamide", "Mometasone", "Naproxen",
            "Ondansetron", "Pantoprazole", "Quinapril", "Ramipril", "Salbutamol", "Tetracycline",
            "Ursodeoxycholic acid", "Valsartan", "Warfarin", "Xylazine", "Yohimbine", "Zidovudine"
    };

    public static String[] company = {
            "MediCore Pharmaceuticals", "NeoGenix Health", "ACI Pharmaceuticals", "BioSphere Pharma",
            "Zenith Pharmaceuticals", "LifeLine Laboratories", "Beximco Pharmaceuticals", "OmegaCure Biotech",
            "GlobalMed Solutions", "EcoPharm Innovations", "Square Pharmaceuticals", "InnoGen Pharma",
            "MediPro Enterprises", "Renata Limited", "Vertex Pharma Solutions", "BioTech Innovations",
            "PharmaPulse Inc.", "Popular Pharmaceuticals", "MediVantage Labs", "NexGen Health Sciences",
            "Aristopharma Ltd.", "Wellness Pharma Group", "Harmony Health Solutions", "Opsonin Pharma Ltd.",
            "IntelliMed Research", "ApexPharma Technologies", "ACME Laboratories Ltd.", "BioQuest Pharmaceuticals",
            "MediCore Innovations", "Square Herbal and Nutraceuticals Ltd."
    };

    public static List<String> getRandomMeds(int n) {
        List<String> names = new ArrayList<String>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int index = rand.nextInt(medsNames.length);
            names.add(medsNames[index]);
        }
        return names;
    }

    public static List<String> getRandomGeneric(int n) {
        List<String> generics = new ArrayList<String>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int index = rand.nextInt(generic.length);
            generics.add(generic[index]);
        }
        return generics;
    }

    public static List<String> getRandomCompany(int n) {
        List<String> companies = new ArrayList<String>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int index = rand.nextInt(company.length);
            companies.add(company[index]);
        }
        return companies;
    }
}
