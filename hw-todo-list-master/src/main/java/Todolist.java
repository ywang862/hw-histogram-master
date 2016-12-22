import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.time.LocalDateTime;

public class Todolist {
    private String[] goals;
    private String[][] goalandtask;
    private String[][] newgoalandtask;
    private String[][] priorityarray;
    private boolean[][] booleanarray;
    private String[][] duetimearray;
    private String[][] subtaskarray;
    public static boolean containthenameornot(ArrayList ar, String name) {
        return (ar.contains(name));
    }
    public Todolist() {

    };
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void putnewname(String a) {
        try {
            File csv = new File("users.csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            bw.write(a);
            bw.newLine();
            bw.close();
            System.out.println();
            System.out.println("Your username is added into our system!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void createcsvfile(String name2) {
        String 4newfilename = name2 + ".csv";
        try {
            File csv = new File(newfilename);
            BufferedWriter bw2 = new BufferedWriter(new
                FileWriter(csv, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Congratulaions, your file is created");
        System.out.println();
        System.out.println("Now you can add tasks and"
            + "goals by reopening the program");
    }
    public String[][] extractfile(String name) {
        int count = 0;
        String newfilename = name + ".csv";
        int maxlength = 0;
        try {
            BufferedReader reader = new BufferedReader(new
                FileReader(newfilename));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                if (item.length > maxlength) {
                    maxlength = item.length;
                }
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        goalandtask = new String[count][maxlength];
        int count2 = 0;
        try {
            BufferedReader reader = new BufferedReader(new
                FileReader(newfilename));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                for (int i = 0; i < item.length; i++) {
                    goalandtask[count2][i] = item[i];
                }
                count2++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return goalandtask;
    }

    public static String checkpriority(String a) {
        String newpriority = a.replaceAll(" ", "");
        int prioritynumber = Integer.parseInt(newpriority);
        if (prioritynumber <= 3) {
            return "low priority";
        } else if (prioritynumber > 3 && prioritynumber <= 6) {
            return "medium priority";
        } else {
            return "high priority";
        }
    }
    public static String checkduetime(String a) {
        String t = a.replaceAll(" ", "");
        return t;
    }

    public static String checksubtask(String a) {
        String t = a;
        return t;
    }
    public static boolean checkcompletion(String b) {
        String newcheckcompletion = b.replaceAll(" ", "");
        return (newcheckcompletion.equals("true"));
    }
    public void addgoal(String answer4goal) {
        if (newgoalandtask.length == 0) {
            String[][] newnewgoalandtask = new String[100][100];
            newnewgoalandtask[0][0] = answer4goal;
            newgoalandtask = newnewgoalandtask;
        } else {
            int rows2 = newgoalandtask.length + 1;
            int cols2 = newgoalandtask[0].length;
            System.out.println(rows2 + " " + cols2);
            String[][] newnewgoalandtask = new String[rows2][cols2];
            for (int i = 0; i < rows2 - 1; i++) {
                for (int j = 0; j < cols2; j++) {
                    newnewgoalandtask[i][j] = newgoalandtask[i][j];
                }
            }
            newgoalandtask = newnewgoalandtask;
            newgoalandtask[rows2 - 1][0] = answer4goal;
        }
    }



    public void addtask(LocalDateTime dateandtime, int answer4task1,
        String taskname, String priority) {
        if (newgoalandtask.length == 0) {
            System.out.println("you have not yet set the goal ><");
            System.out.println();
            System.out.println("Do you want to Set the goal? Yes/No");
            Scanner shabi = new Scanner(System.in);
            if (shabi.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("What is your goal");
                String answer45 = shabi.next();
                addgoal(answer45);
            } else {
                return;
            }
        }
        int rows3 = newgoalandtask.length;
        int cols3 = newgoalandtask[0].length + 1;
        String[][] newnewnewgoalandtask = new String[rows3][cols3];
        for (int i = 0; i < rows3; i++) {
            for (int j = 0; j < cols3 - 1; j++) {
                newnewnewgoalandtask[i][j] = newgoalandtask[i][j];
            }
        }
        newgoalandtask = newnewnewgoalandtask; //checked
        String year = Integer.toString(dateandtime.getYear());
        String month = Integer.toString(dateandtime.getMonthValue());
        String day = Integer.toString(dateandtime.getDayOfMonth());
        String hr = Integer.toString(dateandtime.getHour());
        String minute = Integer.toString(dateandtime.getSecond());
        String tasks = " " + answer4task1 + " | " + priority + " | " + year
            + "-" + month + "-" + day + "-" + hr
            + "T" + minute  + " | " + "false";
        for (int k = 0; k < cols3; k++) {
            if (newgoalandtask[answer4task1 - 1][k] == null) {
                newgoalandtask[answer4task1 - 1][k] = tasks;
                break;
            }
        }
    }

    public void completetask(int answer5task11, int answer5task22) {
        int rows5 = newgoalandtask.length;
        int cols5 = newgoalandtask[0].length;
    }

    public void checkgoalsandtask(String name) {
        newgoalandtask = extractfile(name);
        if (newgoalandtask.length == 0) {
            System.out.println("there is nothing inside this file");
        } else {
            int rows = newgoalandtask.length;
            int cols = newgoalandtask[0].length;
            priorityarray = new String[rows][cols];
            booleanarray = new boolean[rows][cols];
            duetimearray = new String[rows][cols];
            subtaskarray = new String[rows][cols];
            for (int i = 0; i < rows; i++) { // the goals
                int count = 0;
                for (int j = 1; j < cols; j++) { // the tasks
                    if (newgoalandtask[i][j] == null) {
                        break;
                    } else {
                        String[] item = newgoalandtask[i][j].split("\\|");
                        String subtask = checksubtask(item[0]);
                        subtaskarray[i][count] = subtask;
                        boolean finishedornot = checkcompletion(item[3]);
                        booleanarray[i][count] = finishedornot;
                        String priority = checkpriority(item[1]);
                        priorityarray[i][count] = priority; //priority
                        String duetime = checkduetime(item[2]);
                        duetimearray[i][count] = duetime;
                        count++;
                    }
                }
            }
            for (int i = 0; i < rows; i++) { // the goals
                int count2 = 0;
                int count3 = 0;
                boolean trigger6 = true;
                System.out.print(newgoalandtask[i][0]);
                for (int k = 1; k < cols; k++) {
                    if (newgoalandtask[i][k] == null) {
                        break;
                    } else {
                        if (!booleanarray[i][count3]) {
                            trigger6 = false;
                        }
                        count3++;
                    }
                }
                if (!trigger6) {
                    System.out.println("         incomplte");
                } else {
                    System.out.println("          complete");
                }
                for (int j = 1; j < cols; j++) {
                    if (newgoalandtask[i][j] == null) {
                        break;
                    } else {
                        System.out.print("      -" + subtaskarray[i][count2]);
                        System.out.print(" - " + priorityarray[i][count2]);
                        String newtime2 = duetimearray[i][count2];
                        newtime2 = newtime2.replaceAll("T" , " ");
                        System.out.print(" - due " + newtime2);
                        if (booleanarray[i][count2]) {
                            System.out.println(" - " + "complete");
                        } else if (!booleanarray[i][count2]) {
                            System.out.println(" - " + "incomplete");
                        }
                        if (!booleanarray[i][count2]) {
                            trigger6 = false;
                        }
                    }
                    count2++;
                }
            }
        }
    }

    public void overwritethecsvfile(String filename) {
        String newfilename = filename + ".csv";
        int rows4 = newgoalandtask.length;
        int cols4 = newgoalandtask[0].length;
        try {
            File csv = new File(newfilename);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, false));
            for (int i = 0; i < rows4; i++) {
                for (int j = 0; j < cols4; j++) {
                    if (newgoalandtask[i][j] == null) {
                        break;
                    } else {
                        bw.write(newgoalandtask[i][j] + ",");
                    }
                }
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found lol");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        Todolist aa = new Todolist();
        Scanner scanname = new Scanner(System.in);
        System.out.println("what is your user name?");
        String name = scanname.next();
        String[] finalalone = {};
        ArrayList<String> ar = new ArrayList<String>();
        try {
            File filename = new File("users.csv");
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = "";
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                while (st.hasMoreTokens()) {
                    String newname = st.nextToken();
                    ar.add(newname);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean trigger1 = true;
        boolean trigger2 = true;
        boolean trigger3 = true;
        boolean trigger5 = true;
        boolean trigger4 = true;
        boolean trigger99 = true;

        if (!containthenameornot(ar, name)) {
            System.out.println("You username is not existing,"
                + "do you want to create a new one? yes/no");
            String name2 = scanname.next();
            if (name2.equalsIgnoreCase("yes")) {
                putnewname(name);
                createcsvfile(name);
            }
        } else {
            System.out.println("Do you want to see your goals? yes/no");
            String answer2 = scanname.next();
            if (answer2.equalsIgnoreCase("yes")) {
                aa.checkgoalsandtask(name);
                while (trigger99) {
                    trigger4 = true;
                    System.out.println();
                    System.out.println("Select An option!(type integers)");
                    System.out.println("     [1] add goal");
                    System.out.println("     [2] add task");
                    System.out.println("     [3] mark complete");
                    System.out.println("     [4] save and exit");
                    int newanswer3 = 0;
                    while (trigger4) {
                        String answer3 = scanname.next();
                        if (isInteger(answer3)) {
                            if (Integer.parseInt(answer3) <= 4) {
                                newanswer3 = Integer.parseInt(answer3);
                                trigger4 = false;
                            } else {
                                System.out.println("type the integer < 4");
                            }
                        } else {
                            System.out.println();
                            System.out.println("type the integer please!");
                        }
                    }
                    if (newanswer3 == 1) {
                        System.out.println("What is the goal?");
                        String answer4goal = scanname.next();
                        aa.addgoal(answer4goal);
                    } else if (newanswer3 == 2) {
                        System.out.println("Under Which goal would"
                            + "you put your task? (integer only)");
                        for (int n = 0; n < aa.newgoalandtask.length; n++) {
                            System.out.println("    [" + (n + 1) + "]   "
                                + aa.newgoalandtask[n][0]);
                        }
                        int answer4task11 = 0;
                        while (trigger2) {
                            String answer4task1 = scanname.next();
                            if (isInteger(answer4task1)) {
                                if (Integer.parseInt(answer4task1)
                                    <= aa.newgoalandtask.length
                                    | Integer.parseInt(answer4task1) > 0) {
                                    answer4task11
                                        = Integer.parseInt(answer4task1);
                                    trigger2 = false;
                                } else if (Integer.parseInt(answer4task1)
                                      == 0) {
                                    System.out.println("you have not yet"
                                        + "created a goal, please create one");
                                    return;
                                } else {
                                    System.out.println("type the integer"
                                        + "< number of goal");
                                }
                            } else {
                                System.out.println();
                                System.out.println("type the integer please!");
                            }
                        }
                        System.out.println("What is you task called?");
                        String answer4task2 = scanname.next();
                        System.out.println("your priority level 0-9?");
                        String answer4task13 = null;
                        while (trigger3) {
                            String answer4task3 = scanname.next();
                            if (isInteger(answer4task3)) {
                                if (Integer.parseInt(answer4task3) < 10) {
                                    answer4task13 = answer4task3;
                                    trigger3 = false;
                                } else {
                                    System.out.println("type the integer less"
                                        + "than the number of goals please!");
                                }
                            } else {
                                System.out.println();
                                System.out.println("type the integer please!");
                            }
                        }
                        int dueyear = 0, duemonth = 0, dueday = 0, duehr = 0,
                            duemin = 0;
                        boolean triggerduetime1 = true, triggerduetime2 = true,
                            triggerduetime3 = true, triggerduetime4 = true,
                            triggerduetime5 = true;
                        System.out.println("what is the due time?");
                        System.out.println("What is the year of duetime?");
                        while (triggerduetime1) {
                            String answer10 = scanname.next();
                            if (isInteger(answer10)) {
                                dueyear = Integer.parseInt(answer10);
                                triggerduetime1 = false;
                            } else {
                                System.out.println();
                                System.out.println("type the integer please!");
                            }
                        }
                        System.out.println("What is the month of duetime?");
                        while (triggerduetime2) {
                            String answer11 = scanname.next();
                            if (isInteger(answer11)) {
                                if (Integer.parseInt(answer11) < 13) {
                                    duemonth = Integer.parseInt(answer11);
                                    triggerduetime2 = false;
                                } else {
                                    System.out.println("month < 13");
                                }
                            } else {
                                System.out.println();
                                System.out.println("Integer please");
                            }
                        }
                        System.out.println("What is the day of duetime?");
                        while (triggerduetime3) {
                            String answer12 = scanname.next();
                            if (isInteger(answer12)) {
                                if (Integer.parseInt(answer12) < 32) {
                                    dueday = Integer.parseInt(answer12);
                                    triggerduetime3 = false;
                                } else {
                                    System.out.println("type integer < 32");
                                }
                            } else {
                                System.out.println();
                                System.out.println("type the integer please!");
                            }
                        }

                        System.out.println("What is the hour of duetime?");
                        while (triggerduetime4) {
                            String answer13 = scanname.next();
                            if (isInteger(answer13)) {
                                if (Integer.parseInt(answer13) < 24) {
                                    duehr = Integer.parseInt(answer13);
                                    triggerduetime4 = false;
                                } else {
                                    System.out.println("type integer < 24");
                                }
                            } else {
                                System.out.println();
                                System.out.println("type the integer please!");
                            }
                        }

                        System.out.println("What is the minute of duetime?");
                        while (triggerduetime5) {
                            String answer14 = scanname.next();
                            if (isInteger(answer14)) {
                                if (Integer.parseInt(answer14) < 60) {
                                    duemin = Integer.parseInt(answer14);
                                    triggerduetime5 = false;
                                } else {
                                    System.out.println("type the value < 60");
                                }
                            } else {
                                System.out.println();
                                System.out.println("type the integer please!");
                            }
                            LocalDateTime dateTime = LocalDateTime.of(dueyear,
                                duemonth, dueday, duehr, duemin);
                            aa.addtask(dateTime, answer4task11,
                                answer4task2, answer4task13);
                        }
                    } else if (newanswer3 == 3) {
                        boolean trigger22 = true;
                        boolean trigger23 = true;
                        System.out.println("Under Which goal would you mark"
                              + "complete(Integer only)");
                        for (int n = 0; n < aa.newgoalandtask.length; n++) {
                            System.out.println("    [" + (n + 1) + "]   "
                                + aa.newgoalandtask[n][0]);
                        }
                        int answer5task11 = 0;
                        while (trigger22) {
                            String answer5task1 = scanname.next();
                            if (isInteger(answer5task1)) {
                                if (Integer.parseInt(answer5task1)
                                    <= aa.goalandtask.length) {
                                    answer5task11
                                        = Integer.parseInt(answer5task1);
                                    trigger22 = false;
                                } else {
                                    System.out.println("type the integer less"
                                        + "than the number of goals please!");
                                }
                            } else {
                                System.out.println();
                                System.out.println("type the integer please!");
                                answer5task1 = scanname.next();
                            }
                        }
                        System.out.println("Under Which task would you mark"
                            + "complete (integer only)");
                        for (int n = 1; n < aa.newgoalandtask.length; n++) {
                            if (aa.newgoalandtask[answer5task11 -  1][n]
                                == null) {
                                break;
                            } else {
                                System.out.println("    [" + (n) + "]   "
                                    + aa.newgoalandtask[answer5task11 - 1][n]);
                            }
                        }
                        int answer5task22 = 0;
                        while (trigger23) {
                            String answer5task2 = scanname.next();
                            if (isInteger(answer5task2)) {
                                if (Integer.parseInt(answer5task2)
                                      <= aa.goalandtask.length) {
                                    answer5task22
                                        = Integer.parseInt(answer5task2);
                                    trigger23 = false;
                                } else {
                                    System.out.println("Integer < # goals !");
                                }
                            } else {
                                System.out.println();
                                System.out.println("type the integer please!");
                                answer5task2 = scanname.next();
                            }
                        }
                        aa.completetask(answer5task11, answer5task22);
                    } else if (newanswer3 == 4) {
                        trigger99 = false;
                        aa.overwritethecsvfile(name);
                    }
                }
            }
        }
    }
}

