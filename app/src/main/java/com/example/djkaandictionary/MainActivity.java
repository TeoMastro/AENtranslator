package com.example.djkaandictionary;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;

import com.example.djkaandictionary.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    public static DictionaryManagerDatabase manager;
    public List<Dictionary> dict;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        manager = Room.databaseBuilder(getApplicationContext(),DictionaryManagerDatabase.class,"dictionary").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        dict = manager.myDao().getDict();
        //manager.myDao().deleteDict(dict);
        if(dict.isEmpty()){
            initDict();
            Log.i("mphke","troll");
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void initDict(){
        dict.add(new Dictionary("Able seaman","Ναύτης"));
        dict.add(new Dictionary("About","Περίπου"));
        dict.add(new Dictionary("Accomplish a bill of lading","Παραδίνω φορτωτική για παραλαβή φορτίου"));
        dict.add(new Dictionary("Account","Λογαριασμός"));
        dict.add(new Dictionary("Act of God","Ανωτέρα βία"));
        dict.add(new Dictionary("Actual total loss","Πραγματική ολική απώλεια"));
        dict.add(new Dictionary("Ad valorem freight","Ναύλος κατ΄αξίαν"));
        dict.add(new Dictionary("Additional premium","Επιπρόσθετο ασφάλιστρο"));
        dict.add(new Dictionary("Additional clauses ","Συμπληρωματικές ρήτρες ναυλοσυμφώνου"));
        dict.add(new Dictionary("Admissible as general average","Παραδεκτή σαν γενική αβαρία"));
        dict.add(new Dictionary("Additional demurrage","Πρόσθετες επισταλίες"));
        dict.add(new Dictionary("Additional freight","Πρόσθετος ναύλος"));
        dict.add(new Dictionary("Advance to master","Προκαταβολή στον πλοίαρχο"));
        dict.add(new Dictionary("Advice note","Ειδοποίηση η οποία περιγράφει την κατάσταση των εμπορευμάτων, την ημερομηνία άφιξής τους και τον τρόπο παραδόσεως"));
        dict.add(new Dictionary("Affiliated company","Θυγατρική εταιρεία"));
        dict.add(new Dictionary("Aground","Προσαραγμένο"));
        dict.add(new Dictionary("Afloat ","Επιπλέω"));
        dict.add(new Dictionary("Aframax","Με τον όρο αυτό περιγράφεται ένα δεξαμενόπλοιο χωρητικότητας 75.000 – 120.000 DW"));
        dict.add(new Dictionary("Aft","Πρύμα"));
        dict.add(new Dictionary("After peak tank","Πρυμναία δεξαμενή ζυγοσταθμίσεως"));
        dict.add(new Dictionary("Ampient temperature","Θερμοκρασία περιβάλλοντος"));
        dict.add(new Dictionary("Anchorage","Αγκυροβόλιο"));
        dict.add(new Dictionary("Anchorage dues","Αγκυροβολίας τέλη"));
        dict.add(new Dictionary("Annual survey","Ετήσια επιθεώρηση"));
        dict.add(new Dictionary("Ballast","έρμα"));
        dict.add(new Dictionary("Ballast trip","Ταξίδι υπό έρμα"));
        dict.add(new Dictionary("Bareboat charter","Ναύλωση γυμνού πλοίου"));
        dict.add(new Dictionary("Bareboat charter-party","Ναυλοσύμφωνο ναύλωσης γυμνού πλοίου"));
        dict.add(new Dictionary("Barge","Φορτηγίδα (μαούνα/μπάριζα)"));
        dict.add(new Dictionary("Bareboat charterer","Ναυλωτής γυμνού πλοίου"));
        dict.add(new Dictionary("Base cargo","Βασικό φορτίο"));
        dict.add(new Dictionary("Basin","Λεκάνη λιμανιού"));
        dict.add(new Dictionary("Beam","Μέγιστο πλάτος πλοίου"));
        dict.add(new Dictionary("Bearer (of bill of lading)","Κομιστής φορτωτικής"));
        dict.add(new Dictionary("Beaufort Scale","Κλίμακα δύναμης ανέμου"));
        dict.add(new Dictionary("Belt conveyor","r Σύστημα φορτοεκφόρτωσης χύμα φορτίων με ιμάντα"));
        dict.add(new Dictionary("Berth","Μέρος της αποβάθρας όπου ένα πλοίο πλευρίζει για φόρτωση ή εκφόρτωση"));
        dict.add(new Dictionary("Berth terms"," Όροι προβλήτας"));
        dict.add(new Dictionary("Berthage","Τέλη προβλήτας"));
        dict.add(new Dictionary("Berthing","Πλεύριση, προσόρμιση"));
        dict.add(new Dictionary("Bilge","Υδροσυλλέκτης, σεντίνα"));
        dict.add(new Dictionary("Bill","Σύντομη ονομασία της φορτωτικής"));
        dict.add(new Dictionary("Bill of health","Υγειονομική πιστοποίηση"));
        dict.add(new Dictionary("Black products","Ακατέργαστα πετρελαιοειδή"));
        dict.add(new Dictionary("Boat note","Απόδειξη παραλαβής φορτίου"));
        dict.add(new Dictionary("Bollard","Δέστρα, μπίντα"));
        dict.add(new Dictionary("Bonded area","Περιοχή η οποία ελέγχεται από τις τελωνειακές αρχές, στην οποία αποθηκεύονται τα μη εκτελωνισθέντα φορτία"));
        dict.add(new Dictionary("Bonded store","Αποθήκη εμπορευμάτων υπό διαμετακόμιση"));
        dict.add(new Dictionary("Bottom side tank","Πλευρική δεξαμενή στο κάτω μέρος του κύτους"));
        dict.add(new Dictionary("Bow door"," Θύρα στο πρωραίο άκρο του πορθμείου ) για την είσοδο και έξοδο των οχημάτων"));
        dict.add(new Dictionary("Bow ramp","Ράμπα οχηματαγωγού πλοίου η οποία βρίσκεται στο πρωραίο άκρο του πλοίου"));
        dict.add(new Dictionary("Bow thruster","Έλικα πλώρης"));
        dict.add(new Dictionary("Brackish water","Υφάλμυρο νερό"));
        dict.add(new Dictionary("Breach","Παράβαση συμφωνίας"));
        dict.add(new Dictionary("Breadth","Πλάτος"));
        dict.add(new Dictionary("Bridge crane","Γερανογέφυρα"));
        dict.add(new Dictionary("Fair tide","Παλιρροιακό ρεύμα το οποίο αυξάνει την ταχύτητα του πλοίου"));
        dict.add(new Dictionary("Fair wear and tear excepted","Εξαιρουμένης της φυσιολογικής φθοράς"));
        dict.add(new Dictionary("Feeder","Τροφοδοτικό στόμιο"));
        dict.add(new Dictionary("Feeder ship","Τροφοδοτικό πλοίο"));
        dict.add(new Dictionary("Ferry","Πορθμείο"));
        dict.add(new Dictionary("Ferry port","Λιμάνι προσέγγισης πορθμείων"));
        dict.add(new Dictionary("Fertilizer terminal","Τερματικός σταθμός σε λιμάνι, ο οποίος χρησιμοποιείται για φορτία λιπασμάτων"));
        dict.add(new Dictionary("First class ship","Πλοίο στο οποίο έχει αποδοθεί η ανώτερη κλάση του νηογνώμονα"));
        dict.add(new Dictionary("Fixture","Κλείσιμο, ναύλωση του πλοίου"));
        dict.add(new Dictionary("Flag","Η σημαία του πλοίου"));
        dict.add(new Dictionary("Flag discrimination","Διάκριση λόγω σημαίας"));
        dict.add(new Dictionary("Flag of convenience","Σημαία ευκαιρίας"));
        dict.add(new Dictionary("Flag state","Είναι το κράτος, του οποίου το πλοίο φέρει τη σημαία του"));
        dict.add(new Dictionary("Flash point","Σημείο ανάφλεξης"));
        dict.add(new Dictionary("Floating crane","Πλωτός γερανός"));
        dict.add(new Dictionary("Floating dock","Πλωτή δεξαμενή"));
        dict.add(new Dictionary("Folding hatch cover"," Πτυσσόμενα καπάκια αμπαριού"));
        dict.add(new Dictionary("Force majeure","Ανωτέρα βία"));
        dict.add(new Dictionary("Forced ventilation","Τεχνητός ελκυσμός"));
        dict.add(new Dictionary("Fore and aft stowage","Στοιβασία κατά το διάμηκες του πλοίου"));
        dict.add(new Dictionary("Fore peak tank","Πρωραία δεξαμενή ζυγοσταθμίσεως"));
        dict.add(new Dictionary("Foreman","Αρχιεργάτης,εργοδηγός"));
        dict.add(new Dictionary("Fork lift truck","Περονοφόρο όχημα"));
        dict.add(new Dictionary("Forward","Εις ή προς την πλώρη του πλοίου"));
        dict.add(new Dictionary("Foul bill of lading","Μη καθαρή φορτωτική"));
        dict.add(new Dictionary("Fraud","Απάτη, δόλος, δολιότητα"));
        dict.add(new Dictionary("Free alongside ship",". Ελεύθερο στην πλευρά του πλοίου"));
        dict.add(new Dictionary("Free despatch","Ελεύθερον επίσπευσης"));
        dict.add(new Dictionary("Free flow system","Σύστημα ελεύθερης ροής"));
        dict.add(new Dictionary("Free in","Φόρτωση άνευ εξόδων για τον πλοιοκτήτη"));
        dict.add(new Dictionary("Free port","Ελεύθερο λιμάνι"));
        dict.add(new Dictionary("Free pratique","Ελευθεροκοινωνία"));
        dict.add(new Dictionary("Free zone","Ελεύθερη ζώνη"));
        dict.add(new Dictionary("Freeboard","Ύψος εξάλων"));
        dict.add(new Dictionary("Freight","Ναύλος"));
        dict.add(new Dictionary("Freight account","Λογαριασμός του οφειλόμενου ναύλου στον πλοιοκτήτη, σε ναύλωση ταξιδίου ή χρονοναύλωσης"));
        dict.add(new Dictionary("Freight prepaid","Ναύλος προπληρωτέος"));
        dict.add(new Dictionary("Freight rate","Τιμή ναύλου"));
        dict.add(new Dictionary("Freight tarif","Διατίμηση ναύλου"));
        dict.add(new Dictionary("Freighter","Φορτηγό πλοίο"));
        dict.add(new Dictionary("Fresh water allowance","Περιθώριο γλυκού νερού"));
        dict.add(new Dictionary("Fresh water load line","Γραμμή φορτώσεως γλυκού νερού"));
        dict.add(new Dictionary("Frustration","Αδυναμία εκτέλεσης σύμβασης ναυλώσεως"));
        dict.add(new Dictionary("Gantry crane","Γερανογέφυρα"));
        dict.add(new Dictionary("Gas free","Εξαερώνω, απαλλάσσω από αέρια"));
        dict.add(new Dictionary("Gas free certificate","Πιστοποιητικό απαλλαγής από αέρια"));
        dict.add(new Dictionary("Gas oil","Τύπος πετρελαίου ο οποίος χρησιμοποιείται σε μικρές μηχανές ντήζελ, όπως στις ηλεκτρομηχανές των πλοίων ή στις μηχανές πρόωσης μικρών πλοίων"));
        dict.add(new Dictionary("Gas terminal","Τερματικός σταθμός λιμένος στον οποίο αποθηκεύονται φορτία υγραερίων, όπως βουτάνιο και προπάνιο"));
        dict.add(new Dictionary("General cargo","Γενικό φορτίο"));
        dict.add(new Dictionary("General cargo ship","Πλοίο γενικού φορτίου"));
        dict.add(new Dictionary("General purpose container","Εμπορευματοκιβώτιο γενικής χρήσης"));
        dict.add(new Dictionary("General purpose rating","Ναυτικός (υπαξιωματικός ή ναύτης) ο οποίος μπορεί να εργαστεί και στο κατάστρωμα και στη μηχανή"));
        dict.add(new Dictionary("Goods","Εμπορεύματα"));
        dict.add(new Dictionary("Grain berth","Προβλήτα φορτώσεως σιτηρών"));
        dict.add(new Dictionary("Grain capacity","Χωρητικότητα σε σιτηρά"));
        dict.add(new Dictionary("Safe berth","Ασφαλής προβλήτα"));
        dict.add(new Dictionary("Safe port","Ασφαλές λιμάνι"));
        dict.add(new Dictionary("Safe working load","Φορτίο ασφαλείας"));
        dict.add(new Dictionary("Sail","Αποπλέω"));
        dict.add(new Dictionary("Salvage","Ναυαγιαίρεση. Διάσωση πλοίου το οποίο κινδυνεύει ή έχει εξοκείλει ή διάσωση του φορτίου του"));
        dict.add(new Dictionary("Salvage agreement","Συμφωνία ναυαγιαίρεσης"));
        dict.add(new Dictionary("Salvage charges","Έξοδα διάσωσης"));
        dict.add(new Dictionary("Salvor","Ναυαγοσώστης, ναυαγιαιρέτης"));
        dict.add(new Dictionary("Sand dredger","Αμμοληπτικό σκάφος"));
        dict.add(new Dictionary("scow barge","Φορτηγίδα με επίπεδο πυθμένα"));
        dict.add(new Dictionary("Scrap terminal","Τερματικός σταθμός παληοσιδήρων"));
        dict.add(new Dictionary("Seal","Ασφαλιστικός μηχανισμός ο οποίος προσαρτάται στην πόρτα του εμπορευματοκιβωτίου"));
        dict.add(new Dictionary("Seasonal tropical zone","Εποχιακή τροπική ζώνη"));
        dict.add(new Dictionary("Seaworthiness","Αξιοπλοΐα"));
        dict.add(new Dictionary("Seaworthy","Πλοίο αξιόπλουν"));
        dict.add(new Dictionary("Secure","Ασφαλίζω"));
        dict.add(new Dictionary("Seize","Κατάσχω, συλλαμβάνω"));
        dict.add(new Dictionary("Separation","Διαχωρισμός"));
        dict.add(new Dictionary("Service speed","Υπηρεσιακή ταχύτητα"));
        dict.add(new Dictionary("Settlement","Εξόφληση"));
        dict.add(new Dictionary("Shed","Αποθήκη"));
        dict.add(new Dictionary("Shift","Ωράριο εργασίας"));
        dict.add(new Dictionary("Ωράριο εργασίας","Μετακίνηση φορτίου"));
        dict.add(new Dictionary("Shifting charges","Έξοδα μετακίνησης του πλοίου στο λιμάνι"));
        dict.add(new Dictionary("Ship","Πλοίο"));
        dict.add(new Dictionary("Ship breaker ","Πρόσωπο ή εταιρεία πού διαλύουν πλοία"));
        dict.add(new Dictionary("Shipbroker","Μεσίτης ναυτιλιακών συμβάσεων, ναυλομεσίτης"));
        dict.add(new Dictionary("Shipbroking","Ναυλομεσιτεία"));
        dict.add(new Dictionary("Shiploader","Φορτωτής ξηράς με ταινιόδρομο"));
        dict.add(new Dictionary("Shipment","Φορτίο"));
        dict.add(new Dictionary("Shipper","Φορτωτής"));
        dict.add(new Dictionary("Shipping documents","Φορτωτικά έγγραφα"));
        dict.add(new Dictionary("Shipping line","Εταιρεία πλοίων τακτικών γραμμών"));
        dict.add(new Dictionary("Ship’s agency","Ναυτικό πρακτορείο"));
        dict.add(new Dictionary("Ship’s agent","Πράκτορας του πλοίου"));
        dict.add(new Dictionary("Ship’s articles","Ναυτολόγιο"));
        dict.add(new Dictionary("Ship’s dues","Ναυτιλιακά τέλη"));
        dict.add(new Dictionary("Ship’s manifest","Δηλωτικό φορτίου"));
        dict.add(new Dictionary("Shipyard","Ναυπηγείο"));
        dict.add(new Dictionary("Shortage","Έλλειμμα φορτίου"));
        dict.add(new Dictionary("Sister ship","Πλοίο με τις ίδιες προδιαγραφές ενός άλλου πλοίου"));
        dict.add(new Dictionary("Slewing crane","Περιστρεφόμενος γερανός"));
        dict.add(new Dictionary("Slop tank","Δεξαμενή καταλοίπων"));
        dict.add(new Dictionary("Slops","Αποπλύματα"));
        dict.add(new Dictionary("Slow steam","Μειώνω ταχύτητα"));
        dict.add(new Dictionary("Special Survey","Ειδική επιθεώρηση"));
        dict.add(new Dictionary("Specific gravity","Ειδικό βάρος"));
        dict.add(new Dictionary("Stern","Η πρύμνη του πλοίου"));
        dict.add(new Dictionary("Stevedore","Στοιβαδόρος"));
        dict.add(new Dictionary("Stowage","Στοιβασία"));
        dict.add(new Dictionary("Stripping pump","Αντλία αποστραγγίσεως δεξαμενοπλοίου"));
        dict.add(new Dictionary("Sub-charterer","Υποναυλωτής"));
        dict.add(new Dictionary("Survey","Επιθεώρηση"));
        dict.add(new Dictionary("Tandem","Σύζευξη δύο γερανών"));
        dict.add(new Dictionary("Tank barge","Φορτηγίδα δεξαμενή."));
        dict.add(new Dictionary("Tank container","Εμπορευματοκιβώτιο δεξαμενή"));
        dict.add(new Dictionary("Tanker","Δεξαμενόπλοιο"));
        dict.add(new Dictionary("Tanker charter","Ναύλωση δεξαμενοπλοίων"));
        dict.add(new Dictionary("Temperature recorder","Συσκευή καταγραφής της θερμοκρασίας"));
        dict.add(new Dictionary("Territorial sea","Αιγιαλίτιδα ζώνη ή χωρικά ύδατα ή χωρική θάλασσα"));
        dict.add(new Dictionary("Third party","Τρίτο πρόσωπο"));
        dict.add(new Dictionary("Thrower","Μηχάνημα το οποίο εκτοξεύει φορτία χύδην"));
        dict.add(new Dictionary("Tidal dock","k Προβλήτα η οποία υπόκειται στις παλιρροιακές διακυμάνσεις της στάθμης του ύδατος"));
        dict.add(new Dictionary("Timber carrier","Πλοίο μεταφοράς ξυλείας, ξυλάδικο"));
        dict.add(new Dictionary("Time charter","Χρονοναύλωση"));
        dict.add(new Dictionary("Time charter order","Εντολή χρονοναύλωσης"));
        dict.add(new Dictionary("Time charterer","Χρονοναυλωτής"));
        dict.add(new Dictionary("Tonnage","Εκφράζει το βάρος του φορτίου που μπορεί το πλοίο να μεταφέρει"));
        dict.add(new Dictionary("Total deadweight","Ολικό νεκρό βάρος"));
        dict.add(new Dictionary("Total loss","Ολική απώλεια"));
        dict.add(new Dictionary("Tow","Ρυμούλκηση"));
        dict.add(new Dictionary("Transhipment","Μεταφόρτωση από πλοίο σε πλοίο"));
        dict.add(new Dictionary("Transit boxes","Διαμετακομιζόμενα εμπορευματοκιβώτια"));
        dict.add(new Dictionary("Transporter crane","Τύπος γερανού που χρησιμοποιείται για τη φορτοεκφόρτωση εμπορευματοκιβωτίων"));
        dict.add(new Dictionary("Trim","Διαγωγή του πλοίου"));
        dict.add(new Dictionary("Tug","Ρυμουλκό"));
        dict.add(new Dictionary("Turnbuckle","Εντατήρας, σφιγκτήρας"));
        dict.add(new Dictionary("Ullage","Το ύψος του κενού χώρου της δεξαμενής πάνω από την επιφάνεια ενός υγρού φορτίου"));
        dict.add(new Dictionary("Ultra large container ship","Πάρα πολύ μεγάλο πλοίο μεταφοράς εμπορευματοκιβωτίων"));
        dict.add(new Dictionary("Ultra large crude carrier","Πάρα πολύ μεγάλο δεξαμενόπλοιο"));
        dict.add(new Dictionary("Underkeel clearance","Η μικρότερη απόσταση μεταξύ της τρόπιδας του πλοίου και του βυθού της θάλασσας ή του ποταμού"));
        dict.add(new Dictionary("Undock","Βγαίνω από τη δεξαμενή ή τον ντόκο"));
        dict.add(new Dictionary("Unload","Εκφορτώνω"));
        dict.add(new Dictionary("Unmoor","Λύνω τους κάβους"));
        dict.add(new Dictionary("Unseaworthiness","Αναξιοπλοΐα πλοίου"));
        dict.add(new Dictionary("Unseaworthy","Πλοίο αναξιόπλουν"));
        dict.add(new Dictionary("Unstuff","Αδειάζω εμπορευματοκιβώτια"));
        dict.add(new Dictionary("Universal bulk carrier","Παλαιού τύπου πλοίο μεταφοράς φορτίων χύδην, πολλαπλής χρήσεως"));
        dict.add(new Dictionary("Underwriter","Ασφαλιστής"));
        dict.add(new Dictionary("Unclaimed goods","Αζήτητα εμπορεύματα"));
        dict.add(new Dictionary("Under consumption","Μειωμένη κατανάλωση"));
        dict.add(new Dictionary("Unclean bill of lading","Μη καθαρή φορτωτική"));
        dict.add(new Dictionary("Valuation report","Έκθεση επιθεωρητή σχετικά με αποτίμηση αξίας περιουσίας ή αγαθών και αφορά υποθήκες, ασφάλειες (insurances) ή για άλλους λόγους"));
        dict.add(new Dictionary("Valuation scale","Κατάλογος τιμών ναύλου, πλοίων τακτικών γραμμών ή κοινοπραξίας"));
        dict.add(new Dictionary("Vehicle carrier","Οχηματαγωγό"));
        dict.add(new Dictionary("Ventilate","Αερίζω"));
        dict.add(new Dictionary("Ventilated container","Εμπορευματοκιβώτιο σχεδιασμένο να παρέχει αερισμό στα φορτία που περιέχει"));
        dict.add(new Dictionary("Ventilation","Αερισμός"));
        dict.add(new Dictionary("Very large crude carrier","Μεγάλο δεξαμενόπλοιο μεταφοράς αργού πετρελαίου. Λέγεται για πλοία χωρητικότητας μεταξύ 100.000 και 350.000 τόνων DW"));
        dict.add(new Dictionary("Vessel","Πλοίο, σκάφος"));
        dict.add(new Dictionary("Voucher","Απόδειξη, δικαιολογητικό"));
        dict.add(new Dictionary("Voyage account","Δήλωση (απολογισμός) εξόδων/εσόδων ταξιδίου του πλοίου"));
        dict.add(new Dictionary("Voyage charter","Ναύλωση ταξιδίου"));
        dict.add(new Dictionary("Voyage charter party","Ναυλοσύμφωνο ταξιδίου"));
        dict.add(new Dictionary("War clause","Ρήτρα κινδύνων πολέμου"));
        dict.add(new Dictionary("War risk surcharge","Προσαύξηση ναύλου λόγω κινδύνων πολέμου"));
        dict.add(new Dictionary("Warp","Μετακινώ το πλοίο με τους κάβους του"));
        dict.add(new Dictionary("Water ballast","Υδάτινο έρμα"));
        dict.add(new Dictionary("Water density","Πυκνότητα νερού"));
        dict.add(new Dictionary("Water-line","Ίσαλος γραμμή"));
        dict.add(new Dictionary("Wear and tear","Φυσιολογική φθορά"));
        dict.add(new Dictionary("Weather-bound","Αποκλεισμένος λόγω καιρού"));
        dict.add(new Dictionary("Weather deck","Εκτεθειμένο κατάστρωμα"));
        dict.add(new Dictionary("Weather permitting","Καιρού επιτρέποντος"));
        dict.add(new Dictionary("Weight cargo","Βαρύ φορτίο"));
        dict.add(new Dictionary("Well","Βαθούλωμα, χαβούζα"));
        dict.add(new Dictionary("Whaler","Φαλαινοθηρικό, φαλαινοθήρας"));
        dict.add(new Dictionary("Wharf","Αποβάθρα, προβλήτα, κρηπίδωμα"));
        dict.add(new Dictionary("White products","Καθαρά πετρελαιοειδή"));
        dict.add(new Dictionary("Winch"," Βαρούλκο"));
        dict.add(new Dictionary("Wing tank","Πλευρική δεξαμενή πλοίου"));
        dict.add(new Dictionary("Wings","Οι πλευρές του αμπαριού"));
        dict.add(new Dictionary("Winter freeboard","Χειμερινό ύψος εξάλων"));
        dict.add(new Dictionary("Wire lashing","Έχμαση με συρματόσχοινο"));
        dict.add(new Dictionary("cargo hook","άγκιστρο φορτίου"));
        dict.add(new Dictionary("chain","αλυσίδα"));
        dict.add(new Dictionary("conductivity","αγωγιμότητα"));
        dict.add(new Dictionary("conductor","αγωγός"));
        dict.add(new Dictionary("connection","σύνδεση"));
        dict.add(new Dictionary("capsized","αναποδογυρισμένο"));
        dict.add(new Dictionary("collision","σύγκρουση"));
        dict.add(new Dictionary("cadet","δόκιμος"));
        dict.add(new Dictionary("chief officer","υποπλοίαρχος , γραμματικός"));
        dict.add(new Dictionary("chief engineer","πρώτος μηχανικός"));
        dict.add(new Dictionary("captain","καπετάνιος, πλοίαρχος"));
        dict.add(new Dictionary("cook","μάγειρας"));
        dict.add(new Dictionary("cargo","φορτίο"));
        dict.add(new Dictionary("cargo hold","δεξαμενή φορτίου"));
        dict.add(new Dictionary("crankshaft","στροφαλοφόρος άξονας"));
        dict.add(new Dictionary("crankcase","στροφαλοθάλαμος"));
        dict.add(new Dictionary("camshaft","εκκεντροφόρος άξονας"));
        dict.add(new Dictionary("centrifugal pump","φυγοκεντρική αντλία"));
        dict.add(new Dictionary("condenser","συμπηκνωτής"));
        dict.add(new Dictionary("condensate","συμπήκνωμα"));
        dict.add(new Dictionary("confiscate","κατάσχω"));
        dict.add(new Dictionary("crane","γερανός"));
        dict.add(new Dictionary("chainlocker","χώρος αποθήκευσης αλυσίδας άγκυρας"));
        dict.add(new Dictionary("crude oil","αργό πετρέλαιο"));
        dict.add(new Dictionary("dock","λιμάνι, ντόκος"));
        dict.add(new Dictionary("drain","στραγγίζω"));
        dict.add(new Dictionary("deaerating tank","απαερωτική δεξαμενή"));
        dict.add(new Dictionary("dismissal","απόλυση"));
        dict.add(new Dictionary("decommision","παροπλίζω, βγάζω εκτός λειτουργίας"));
        dict.add(new Dictionary("deck","κατάστρωμα"));
        dict.add(new Dictionary("drill ships","πλοία τρυπάνια"));
        dict.add(new Dictionary("dry cargo","ξηρό φορτίο"));
        dict.add(new Dictionary("decontaminate","απολυμαίνω"));
        dict.add(new Dictionary("discharge","ξεφορτώνω, απολύω"));
        dict.add(new Dictionary("danger","κίνδυνος"));
        dict.add(new Dictionary("dredger","πλοίο το οποίο σκάβει τον πυθμένα της θάλασσας"));
        dict.add(new Dictionary("demands","απαιτήσεις"));
        dict.add(new Dictionary("depth gauge","δείκτης βάθους"));
        dict.add(new Dictionary("diagram","διάγραμμα"));
        dict.add(new Dictionary("disposable","μιας χρήσης"));
        dict.add(new Dictionary("diameter","διάμετρος"));
        dict.add(new Dictionary("distribute","διανέμω"));
        dict.add(new Dictionary("duration","διάρκεια"));
        dict.add(new Dictionary("distance","απόσταση"));
        dict.add(new Dictionary("dispersants","διασκορπιστικά"));
        dict.add(new Dictionary("dimensions","διαστάσεις"));
        dict.add(new Dictionary("device","συσκευή"));
        dict.add(new Dictionary("eco","οικολογικό"));
        dict.add(new Dictionary("echo","ηχό"));
        dict.add(new Dictionary("ebonite","εβονίτης"));
        dict.add(new Dictionary("entry","εγγραφή σε ημερολόγιο , είσοδος σε κάποιον χώρο"));
        dict.add(new Dictionary("emmisions","εκπομπή (αερίων)"));
        dict.add(new Dictionary("enclosed space","κλειστός χώρος (αεροστεγής)"));
        dict.add(new Dictionary("emergency","έκτακτη ανάγκη"));
        dict.add(new Dictionary("erosion","διάβρωση"));
        dict.add(new Dictionary("equipment","εξοπλισμός"));
        dict.add(new Dictionary("electrical","ηλεκτρικό"));
        dict.add(new Dictionary("engine","μηχανή"));
        dict.add(new Dictionary("engineer","μηχανικός"));
        dict.add(new Dictionary("electrician","ηλεκτρολόγος"));
        dict.add(new Dictionary("embarkation","επιβίβαση"));
        dict.add(new Dictionary("extinguisher","πυροσβεστήρας"));
        dict.add(new Dictionary("evacuate","εγκαταλείπω"));
        dict.add(new Dictionary("emergency generator","γεννήτρια έκτακτης ανάγκης"));
        dict.add(new Dictionary("engine room","μηχανοστάσιο"));
        dict.add(new Dictionary("elevator","ασανσέρ , ανελκυστήρας"));
        dict.add(new Dictionary("explosion","έκρηξη"));
        dict.add(new Dictionary("execute order","εκτελώ εντολή"));
        dict.add(new Dictionary("estimation","εκτίμηση"));
        dict.add(new Dictionary("ejector","εγχυτήρας"));
        dict.add(new Dictionary("energy","ενέργεια"));
        dict.add(new Dictionary("effect","επίδραση"));
        dict.add(new Dictionary("endanger","βάζω σε κίνδυνο"));
        dict.add(new Dictionary("export","εξάγω"));
        dict.add(new Dictionary("expansion","επέκταση"));
        dict.add(new Dictionary("evaporator","αποστακτήρας"));
        dict.add(new Dictionary("help","βοηθάω,βοήθεια"));
        dict.add(new Dictionary("horizontal","οριζόντιος"));
        dict.add(new Dictionary("harness","ιμάντας"));
        dict.add(new Dictionary("hemishpere","ημισφαίριο"));
        dict.add(new Dictionary("health requirements","απαιτήσεις υγείας"));
        dict.add(new Dictionary("handheld","χειροκίνητο"));
        dict.add(new Dictionary("harbour","λιμάνι"));
        dict.add(new Dictionary("heel","κλίση"));
        dict.add(new Dictionary("hour","ώρα"));
        dict.add(new Dictionary("hatch","άνοιγμα, καπάκι"));
        dict.add(new Dictionary("hand-over duties","παραδίδω καθήκοντα"));
        dict.add(new Dictionary("handling","χειρισμός, αντιμετώπιση"));
        dict.add(new Dictionary("housing","θήκη , σώμα που περιβάλλει κάποιο αντικείμενο"));
        dict.add(new Dictionary("halogen lamps","λάμπες αλογόνου"));
        dict.add(new Dictionary("internal","εσωτερικό"));
        dict.add(new Dictionary("information","πληροφορία"));
        dict.add(new Dictionary("instructions","οδηγίες"));
        dict.add(new Dictionary("intention","πρόθεση"));
        dict.add(new Dictionary("impact","επίπτωση , σύγκρουση"));
        dict.add(new Dictionary("horsepower","ιπποδύναμη"));
        dict.add(new Dictionary("intrinsically safe","εγγενώς ασφαλής"));
        dict.add(new Dictionary("immidiate","απότομα , άμεσος"));
        dict.add(new Dictionary("isolation","μόνωση"));
        dict.add(new Dictionary("immersion suit","στολή εμβαπτίσεως"));
        dict.add(new Dictionary("inundation","κατάκλυση"));
        dict.add(new Dictionary("jettison","κάνω αβαρία, εγκαταλείπω"));
        dict.add(new Dictionary("inclination","κλίση"));
        dict.add(new Dictionary("jump overboard","πηδάω από το πλοίο"));
        dict.add(new Dictionary("jog knol","κόμβος δρομομέτρου"));
        dict.add(new Dictionary("yacht","γιοτ, πλοίο αναψυχής"));
        dict.add(new Dictionary("long","μακρύ"));
        dict.add(new Dictionary("maritime code","ναυτικός κώδικας"));
        dict.add(new Dictionary("oar","κουπί"));
        dict.add(new Dictionary("hurricane","τυφώνας"));
        dict.add(new Dictionary("lamp","λάμπα"));
        dict.add(new Dictionary("laminate","πλαστικοποιώ"));
        dict.add(new Dictionary("lower","κατεβάζω,χαμηλώνω"));
        dict.add(new Dictionary("limit","περιορίζω , όριο"));
        dict.add(new Dictionary("list","κλίση , λίστα"));
        dict.add(new Dictionary("lathe","τόρνος"));
        dict.add(new Dictionary("learn","μαθάινω"));
        dict.add(new Dictionary("later","αργότερα"));
        dict.add(new Dictionary("legal requirements","νομικές υποχρεώσεις"));
        dict.add(new Dictionary("load","φορτώνω"));
        dict.add(new Dictionary("loading port","λιμάνι φόρτωσης"));
        dict.add(new Dictionary("large","μεγάλος"));
        dict.add(new Dictionary("incinerator","αποτεφρωτήρας"));
        dict.add(new Dictionary("line","γραμμή"));
        dict.add(new Dictionary("low sulphur","χαμηλό σε θείο"));
        dict.add(new Dictionary("last port of call","τελευταία προσέγγιση λιμανιού"));
        dict.add(new Dictionary("maritime law","ναυτικό δίκαιο"));
        dict.add(new Dictionary("margins","όρια"));
        dict.add(new Dictionary("machine","μηχάνημα"));
        dict.add(new Dictionary("mechanism","μηχανισμός"));
        dict.add(new Dictionary("motor","κινητήρας"));
        dict.add(new Dictionary("machinery","μηχανήματα"));
        dict.add(new Dictionary("mast","κατάρτι"));
        dict.add(new Dictionary("membrane","μεμβράνη"));
        dict.add(new Dictionary("muffler","σιγαστήρας"));
        dict.add(new Dictionary("main deck","κύριο κατάστρωμα"));
        dict.add(new Dictionary("maximum capacity","μέγιστη χωρητικότητα"));
        dict.add(new Dictionary("means of transport","μέσα μεταφοράς"));
        dict.add(new Dictionary("manning","επάνδρωση"));
        dict.add(new Dictionary("needs","ανάγκες"));
        dict.add(new Dictionary("neutral","ουδέτερο"));
        dict.add(new Dictionary("new","καινούργιο"));
        dict.add(new Dictionary("next","επόμενο"));
        dict.add(new Dictionary("naval forces","ναυτικές δυνάμεις"));
        dict.add(new Dictionary("navy","ναυτικό"));
        dict.add(new Dictionary("jetty","λιμενοβραχίωνας"));
        dict.add(new Dictionary("nationality","εθνικότητα"));
        dict.add(new Dictionary("near-miss","ατύχημα,παράβλεψη"));
        dict.add(new Dictionary("net","δίχτυα"));
        dict.add(new Dictionary("neglect","παραμέληση ,αμέλεια"));
        dict.add(new Dictionary("name","όνομα"));
        dict.add(new Dictionary("overhaul","ολική επισκευή"));
        dict.add(new Dictionary("navigation","ναυσιπλο'ί'α"));
        dict.add(new Dictionary("ordinary seaman","ναύτης καταστρώματος"));
        dict.add(new Dictionary("nautical term","ναυτικός όρος"));
        dict.add(new Dictionary("navigate","πλέω ,κυβερνώ"));
        dict.add(new Dictionary("officer","αξιωματικός"));
        dict.add(new Dictionary("officer quarters","δωμάτια αξιωματικών"));
        dict.add(new Dictionary("obligate","υποχρεώνω"));
        dict.add(new Dictionary("obligations","υποχρεώσεις"));
        dict.add(new Dictionary("octane","οκτάνια"));
        dict.add(new Dictionary("oxygen","οξυγόνο"));
        dict.add(new Dictionary("oath","όρκος"));
        dict.add(new Dictionary("outer tanks","εξωτερικές δεξαμενές"));
        dict.add(new Dictionary("oil","λάδι"));
        dict.add(new Dictionary("oil water separator","φυγοκεντρικός διαχωριστήρας λαδιού"));
        dict.add(new Dictionary("oil filter","φίλτρο λαδιού"));
        dict.add(new Dictionary("ocean","ωκεανός"));
        dict.add(new Dictionary("observations","παρατηρήσεις"));
        dict.add(new Dictionary("offense","αδίκημα,παράβαση"));
        dict.add(new Dictionary("operate","λειτουργώ , χειρίζομαι"));
        dict.add(new Dictionary("order","παραγγελία"));
        dict.add(new Dictionary("organization","οργανισμός"));
        dict.add(new Dictionary("original","γνήσιο , αυθεντικό"));
        dict.add(new Dictionary("oxygen mask","μάσκα οξυγόνου"));
        dict.add(new Dictionary("permit","άδεια"));
        dict.add(new Dictionary("pressure","πίεση"));
        dict.add(new Dictionary("problem","πρόβλημα"));
        dict.add(new Dictionary("participate","παίρνω μέρος"));
        dict.add(new Dictionary("pole compass","παραλλακτική πυξίδα"));
        dict.add(new Dictionary("pulse","παλμός"));
        dict.add(new Dictionary("parallel","παράλληλος"));
        dict.add(new Dictionary("propeller","προπέλα"));
        dict.add(new Dictionary("propane","προπάνιο"));
        dict.add(new Dictionary("petrealaum","πετρέλαιο"));
        dict.add(new Dictionary("progress","πρόοδος"));
        dict.add(new Dictionary("piston","έμβολο"));
        dict.add(new Dictionary("pratique","επικοινωνία"));
        dict.add(new Dictionary("pause","πάυω, σταματάω"));
        dict.add(new Dictionary("power","δύναμη, ισχύς"));
        dict.add(new Dictionary("plate","πλάκα,έλασμα"));
        dict.add(new Dictionary("pin","πείρος"));
        dict.add(new Dictionary("pirate","πειρατής"));
        dict.add(new Dictionary("piracy","ειρατία"));
        dict.add(new Dictionary("paint","μπογιά, βάφω"));
        dict.add(new Dictionary("plank","ξύλο"));
        dict.add(new Dictionary("period","περίοδος"));
        dict.add(new Dictionary("queue","ουρά αναμονής"));
        dict.add(new Dictionary("qualification","πιστοποίηση"));
        dict.add(new Dictionary("quality","ποιότητα"));
        dict.add(new Dictionary("quantity","ποσότητα"));
        dict.add(new Dictionary("quarter","τρίμηνο"));
        dict.add(new Dictionary("quick","γρήγορα"));
        dict.add(new Dictionary("question","ερώτηση"));
        dict.add(new Dictionary("pilot","πιλότος,πλοηγός"));
        dict.add(new Dictionary("regulate","ρυθμίζω"));
        dict.add(new Dictionary("radiowave","ραδιοκύματα"));
        dict.add(new Dictionary("radio officer","ασυρματιστής"));
        dict.add(new Dictionary("radio","ασύρματος"));
        dict.add(new Dictionary("requirements","απαιτήσεις"));
        dict.add(new Dictionary("request","ζητάω"));
        dict.add(new Dictionary("readiness","ετοιμότητα"));
        dict.add(new Dictionary("rate","ρυθμός,τιμή,ποσότητα ανα μονάδα χρόνου"));
        dict.add(new Dictionary("replenish","αναπληρώνω"));
        dict.add(new Dictionary("raw","ωμός"));
        dict.add(new Dictionary("refrigarators","ψυγεία,καταψύκτες"));
        dict.add(new Dictionary("resignation","παραίτηση"));
        dict.add(new Dictionary("remarks","παρατηρήσεις"));
        dict.add(new Dictionary("requisition form","αίτηση παραγγελίας"));
        dict.add(new Dictionary("receiver","δέκτης"));
        dict.add(new Dictionary("retrofit","μετασκευή"));
        dict.add(new Dictionary("resistance","αντίσταση"));
        dict.add(new Dictionary("ro-ro","οχηματαγωγό πλοίο"));
        dict.add(new Dictionary("rags","πανιά"));
        dict.add(new Dictionary("records","εγγραφές"));
        dict.add(new Dictionary("reliable","αξιόπιστος"));
        dict.add(new Dictionary("yellow fever","κίτρινος πυρετός"));
        dict.add(new Dictionary("year","χρονιά"));
        dict.add(new Dictionary("pump","αντλία"));
        dict.add(new Dictionary("hull","γάστρα"));
        dict.add(new Dictionary("zone","ζώνη,όρια"));
        dict.add(new Dictionary("zig-zag","γρήγορη ελιγμοί δεξιά αριστερά"));

        manager.myDao().insertMultipleWords(dict);

    }
}