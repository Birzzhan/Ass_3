package com.company;

public class Main {

    public static void main(String[] args) {
        DataBase dataBase =new PatientsTable(new DoctorsTable(new DriversTable(new HospitalDB())));

        System.out.println(dataBase.CreateData());
    }

//    ConcreteComponent
    public static class HospitalDB implements DataBase{
        @Override
        public String CreateData() {
            return "HospitalDB was created!\n";
        }
    }


//    ConcreteDecorators
    public static class DoctorsTable implements AddTable{
        private DataBase db;

        public DoctorsTable(DataBase db){
            this.db = db;
        }

        @Override
        public String CreateData() {
            return db.CreateData() + "'Doctors' table was added in your DB!\n";
        }
    }


    public static class PatientsTable implements AddTable{
        private DataBase db;

        public PatientsTable(DataBase db){
            this.db = db;
        }

        @Override
        public String CreateData() {
            return db.CreateData() + "'Patients' table was added in your DB!\n";
        }
    }


    public static class DriversTable implements AddTable{
        private DataBase db;

        public DriversTable(DataBase db){
            this.db = db;
        }

        @Override
        public String CreateData() {
            return db.CreateData() + "'Drivers' table was added in your DB!\n";
        }
    }

}
