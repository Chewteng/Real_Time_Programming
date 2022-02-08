package my.uum;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

/**
 * This class is the main structure of s263117_A202_bot. It will receive the input through Telegram Bots and return back the result from the Sqlite database.
 *
 * @author H'ng Chew Teng
 */
public class telegramBot extends TelegramLongPollingBot {

    /**
     * This method is to read the bot username
     * @return The registered bot username
     */
    @Override
    public String getBotUsername() {
        return "s263117_A202_bot";
    }

    /**
     * This method is to read the bot token from BotFather
     *
     * @return The registered bot token
     */
    @Override
    public String getBotToken() {
        return "1576763168:AAGG2qLLie42J7M6vFbLIcKhjfsmawq5HMs";
    }

    /**
     * The method is to create a new ArrayList for the output
     */
    public static ArrayList Output = new ArrayList();

    public boolean StartBots = false;

    /**
     * This method is to reply the input message through Telegram Bots and send back the output
     *
     * @param update The new input through Telegram Bots
     */
    @Override
    public void onUpdateReceived(Update update) {

        ArrayList<StudentData3> studentData = Main.studentData;
        ArrayList<StudentData3> githubData1 = Main.githubData1;
        ArrayList<StudentData3> githubData2 = Main.githubData2;
        ArrayList<StudentData> youtubeData1 = Main.youtubeData1;
        ArrayList<StudentData> youtubeData2 = Main.youtubeData2;
        ArrayList<StudentData3> wrongMatricData = Main.wrongMatricData;

        // Check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            try {
                if (message_text.contains("/start")) {
                    SendMessage coreMessage = SendMessage // Create a message object object
                            .builder()
                            .chatId(Long.toString(chat_id))
                            .text("Please select one option:\n" +
                                    "/matricno\n" +
                                    "/totalstudent\n" +
                                    "/githubsubmission\n" +
                                    "/youtubesubmission\n"
                            )
                            .build();
                    StartBots = true;

                    try {
                        execute(coreMessage);
                        // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                } else if (!StartBots) {

                    SendMessage coreMessage = SendMessage // Create a message object object
                            .builder()
                            .chatId(Long.toString(chat_id))
                            .text("Please enter /start to use this function \uD83D\uDE48")
                            .build();

                    try {
                        execute(coreMessage);
                        // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                } else if (message_text.contains("/totalstudent")) {

                    String studentIndex = "\n";

                    StringBuilder string = new StringBuilder();

                    StudentData3 studentInfo = new StudentData3("", "");

                    for (int i = 0; i < studentData.size(); i++) {
                        studentInfo = new StudentData3(studentData.get(i).getMatric(), studentData.get(i).getName());
                        studentIndex += String.format("%-1s.  %-7s --> %-50s\n", i+1, studentInfo.getMatric(), studentInfo.getName());
                    }

                    string.append("\n*Student in STIW3054 Real Time Programming Class-A202* \uD83C\uDF93 " + "\n"
                            + "\n \u27A1\uFE0F Total Student (s) : " + studentData.size() + "\n" +
                            "\nBelow is the list of students: \n" + studentIndex + "\n");

                    SendMessage totalStudentMessage = new SendMessage().builder()
                            .chatId(Long.toString(chat_id))
                            .text(string.toString())
                            .build();
                    totalStudentMessage.setParseMode(ParseMode.MARKDOWN);

                    try {
                        execute(totalStudentMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    try {
                        execute(new SendMessage() // Create a message object object
                                .builder()
                                .chatId(Long.toString(chat_id))
                                .text("Please select one option:\n" +
                                        "/matricno\n" +
                                        "/totalstudent\n" +
                                        "/githubsubmission\n" +
                                        "/youtubesubmission\n"
                                )
                                .build());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else if (message_text.contains("/githubsubmission")){

                    String githubIndex = "\n";

                    StringBuilder githubString = new StringBuilder();

                    StudentData3 githubInfo = new StudentData3("", "");

                    for (int i = 0; i < githubData2.size(); i++) {
                            githubInfo = new StudentData3(githubData2.get(i).getMatric(), githubData2.get(i).getName());
                            githubIndex += String.format("%-1s.  %-7s --> %-50s\n", i+1, githubInfo.getMatric(), githubInfo.getName());
                        }

                    githubString.append("\n \u2754 *Github Account Submission* \n"
                            + "\n \u2714 Total Student (s) who have submitted: " + (29-githubData2.size()) +  "\n" +
                            "\u274C  Total Student (s) who have NOT submitted: " + githubData2.size() +  "\n" +
                            "\nBelow is the student (s) who have NOT submitted the GitHub account : \n" + githubIndex );

                    SendMessage githubMessage = new SendMessage().builder()
                            .chatId(Long.toString(chat_id))
                            .text(githubString.toString())
                            .build();
                    githubMessage.setParseMode(ParseMode.MARKDOWN);

                    try {
                        execute(githubMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    try {
                        execute(new SendMessage() // Create a message object object
                                .builder()
                                .chatId(Long.toString(chat_id))
                                .text("Please select one option:\n" +
                                        "/matricno\n" +
                                        "/totalstudent\n" +
                                        "/githubsubmission\n" +
                                        "/comparegithubsubmission\n" +
                                        "/youtubesubmission\n"
                                )
                                .build());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else if (message_text.contains("/comparegithubsubmission")){

                    String githubIndex1 = "\n";
                    String githubIndex2 = "\n";
                    String wrongMatricIndex = "\n";

                    StringBuilder githubString = new StringBuilder();

                    StudentData3 githubInfo = new StudentData3("", "");

                    for (int i = 0; i < githubData1.size(); i++) {
                        githubInfo = new StudentData3(githubData1.get(i).getMatric(), githubData1.get(i).getName());
                        githubIndex1 += String.format("%-1s.  %-7s --> %-50s\n", i+1, githubInfo.getMatric(), githubInfo.getName());
                    }

                    for (int j = 0; j < githubData2.size(); j++) {
                        githubInfo = new StudentData3(githubData2.get(j).getMatric(), githubData2.get(j).getName());
                        githubIndex2 += String.format("%-1s.  %-7s --> %-50s\n", j+1, githubInfo.getMatric(), githubInfo.getName());
                    }

                    for (int k = 0; k < wrongMatricData.size(); k++) {
                        githubInfo = new StudentData3(wrongMatricData.get(k).getMatric(), wrongMatricData.get(k).getName());
                        wrongMatricIndex += String.format("%-1s.  %-7s --> %-50s\n", k+1, githubInfo.getMatric(), githubInfo.getName());
                    }

                    githubString.append("\n \u2754 *Github Account Submission* \n" +
                            "\n \u27A1\uFE0F Below is the student (s) who have submitted the GitHub account with the correct matric number: \n" + githubIndex1 +
                                    "\n \u27A1\uFE0F Below is the student (s) who have submitted the GitHub account but have the wrong matric number: \n" + wrongMatricIndex +
                                    "\n \u27A1\uFE0F Below is the student (s) who have NOT submitted the GitHub account: \n" + githubIndex2 );

                    SendMessage githubMessage = new SendMessage().builder()
                            .chatId(Long.toString(chat_id))
                            .text(githubString.toString())
                            .build();
                    githubMessage.setParseMode(ParseMode.MARKDOWN);

                    try {
                        execute(githubMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    try {
                        execute(new SendMessage() // Create a message object object
                                .builder()
                                .chatId(Long.toString(chat_id))
                                .text("Please select one option:\n" +
                                        "/matricno\n" +
                                        "/totalstudent\n" +
                                        "/githubsubmission\n" +
                                        "/youtubesubmission\n"
                                )
                                .build());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else if (message_text.contains("/youtubesubmission")){

                    String youtubeIndex = "\n";

                    StringBuilder youtubeString = new StringBuilder();

                    StudentData youtubeInfo = new StudentData("","");

                    for (int j = 0; j < youtubeData2.size(); j++) {
                        youtubeInfo = new StudentData(youtubeData2.get(j).getMatric(), youtubeData2.get(j).getName());
                        youtubeIndex += String.format("%-1s.  %-7s --> %-50s\n", j+1, youtubeInfo.getMatric(), youtubeInfo.getName());
                    }

                    youtubeString.append("\n \u2754 *YouTube Video Submission* \n"
                            + "\n \u2714 Total Student (s) who have submitted: " + youtubeData1.size() +  "\n" +
                            "\u274C Total Student (s) who have NOT submitted: " + youtubeData2.size() +  "\n" +
                            "\nBelow is the student (s) who have NOT submitted the YouTube Video: \n" + youtubeIndex);

                    SendMessage youtubeMessage = new SendMessage().builder()
                            .chatId(Long.toString(chat_id))
                            .text(youtubeString.toString())
                            .build();
                    youtubeMessage.setParseMode(ParseMode.MARKDOWN);

                    try {
                        execute(youtubeMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    try {
                        execute(new SendMessage() // Create a message object object
                                .builder()
                                .chatId(Long.toString(chat_id))
                                .text("Please select one option:\n" +
                                        "/matricno\n" +
                                        "/totalstudent\n" +
                                        "/githubsubmission\n" +
                                        "/youtubesubmission\n" +
                                        "/compareyoutubesubmission\n"
                                )
                                .build());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else if (message_text.contains("/compareyoutubesubmission")){

                    String youtubeIndex1 = "\n";
                    String youtubeIndex2 = "\n";

                    StringBuilder youtubeString = new StringBuilder();

                    StudentData youtubeInfo = new StudentData("","");

                    for (int i = 0; i < youtubeData1.size(); i++) {
                        youtubeInfo = new StudentData(youtubeData1.get(i).getMatric(), youtubeData1.get(i).getName());
                        youtubeIndex1 += String.format("%-1s.  %-7s --> %-50s\n", i+1, youtubeInfo.getMatric(), youtubeInfo.getName());
                    }

                    for (int j = 0; j < youtubeData2.size(); j++) {
                        youtubeInfo = new StudentData(youtubeData2.get(j).getMatric(), youtubeData2.get(j).getName());
                        youtubeIndex2 += String.format("%-1s.  %-7s --> %-50s\n", j+1, youtubeInfo.getMatric(), youtubeInfo.getName());
                    }

                    youtubeString.append("\n \u2754 *YouTube Video Submission* \n" +
                                    "\n \u27A1\uFE0F Below is the student (s) who have submitted the YouTube Video: \n" + youtubeIndex1 +
                            "\n \u27A1\uFE0F Below is the student (s) who have NOT submitted the YouTube Video: \n" + youtubeIndex2);

                    SendMessage youtubeMessage = new SendMessage().builder()
                            .chatId(Long.toString(chat_id))
                            .text(youtubeString.toString())
                            .build();
                    youtubeMessage.setParseMode(ParseMode.MARKDOWN);

                    try {
                        execute(youtubeMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    try {
                        execute(new SendMessage() // Create a message object object
                                .builder()
                                .chatId(Long.toString(chat_id))
                                .text("Please select one option:\n" +
                                        "/matricno\n" +
                                        "/totalstudent\n" +
                                        "/githubsubmission\n" +
                                        "/youtubesubmission\n"
                                )
                                .build());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (message_text.contains("/matricno")) {

                    SendMessage matricMessage = new SendMessage().builder()
                            .chatId(Long.toString(chat_id))
                            .text("Hi, kindly enter the Matric Number" + "\n*Example: 263117* \uD83D\uDE09")
                            .build();
                    matricMessage.setParseMode(ParseMode.MARKDOWN);

                    try {
                        execute(matricMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                } else {

                    Thread t1 = new Thread(new Runnable() {

                        StudentData3 studentInfo = new StudentData3("", "", "", "", "", "");
                        boolean wronginput = false;

                        @Override
                        public void run() {
                            for (int i = 0; i < studentData.size(); i++) {
                                if (message_text.equals(studentData.get(i).getMatric())) {
                                    studentInfo = new StudentData3(studentData.get(i).getMatric(), studentData.get(i).getName(), studentData.get(i).getGithubName(), studentData.get(i).githubLink, studentData.get(i).getYoutubeLink(), studentData.get(i).getYoutubeName());
                                    break;
                                } else if (i == studentData.size() - 1) {
                                    wronginput = true;
                                }

                            }
                            if (!wronginput) {

                                StringBuilder str = new StringBuilder();

                                str.append("\n    \uD83D\uDD39 *Name:* " + studentInfo.getName()
                                                + "\n\uD83D\uDD39 *Github ID:* " + studentInfo.getGithubName()

                                                + "\n\uD83D\uDD39 *Youtube Link:* " + studentInfo.getYoutubeLink()
                                                + "\n\uD83D\uDD39 *Youtube Channel Name:* " + studentInfo.getYoutubeName()
                                        + "\n\uD83D\uDD39 *Github Link:* " + studentInfo.getGithubLink());

                                for (Object i : Output) {
                                    str.append("\n" + i);
                                }

                                SendMessage studentDetailsMessage = new SendMessage().builder()
                                        .chatId(Long.toString(chat_id))
                                        .text(str.toString())
                                        .build();
                                studentDetailsMessage.setParseMode(ParseMode.MARKDOWN);

                                try {
                                    execute(studentDetailsMessage);
                                } catch (TelegramApiException e) {
                                    e.printStackTrace();
                                }

                                try{
                                    execute(new SendMessage() // Create a message object object
                                            .builder()
                                            .chatId(Long.toString(chat_id))
                                            .text("Please select one option:\n" +
                                                    "/matricno\n" +
                                                    "/totalstudent\n" +
                                                    "/githubsubmission\n" +
                                                    "/youtubesubmission\n"
                                            )
                                            .build());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            } else {
                                SendMessage errorMessage = new SendMessage().builder()
                                        .chatId(Long.toString(chat_id))
                                        .text("*Wrong input...* \uD83D\uDE1E \n\nPlease select one option:\n" +
                                                "/matricno\n" +
                                                "/totalstudent\n" +
                                                "/githubsubmission\n" +
                                                "/youtubesubmission\n")
                                        .build();
                                errorMessage.setParseMode(ParseMode.MARKDOWN);

                                try {
                                    execute(errorMessage);
                                } catch (TelegramApiException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    t1.start();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
