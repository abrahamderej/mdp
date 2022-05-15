package edu.miu.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import edu.miu.quizapp.R
import edu.miu.quizapp.data.Quiz
import edu.miu.quizapp.data.QuizDB
import edu.miu.quizapp.utils.BaseFragment
import edu.miu.quizapp.utils.PrefManager
import kotlinx.coroutines.launch

class SplashScreenFragment : BaseFragment() {

    private lateinit var tvWelcome: TextView
    private var prefManager: PrefManager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        prefManager = PrefManager(context)
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        tvWelcome = view.findViewById(R.id.logo_welcome)
        insertDataToDB()
        return view
    }

    override fun onResume(){
        super.onResume()
        tvWelcome.postDelayed({
            if (prefManager?.isFirstTimeLaunch()!!) {
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_homeFragment)
            }else{
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_welcomeFragment)
            }
        }, 1500)
    }

    fun insertDataToDB(){
        val quiz1 = Quiz(1L,"1) ADB stands for -","A. Android debug bridge", "B. Android delete bridge","C. Android destroy bridge","D. None of the above","a","Answer: (a) Android debug bridge\n" +
                "\n" +
                "ADB stands for Android Debug Bridge. It is a command-line tool that is used to communicate with the emulator instance.")
        val quiz2 = Quiz(2L,"2) On which of the following, developers can test the application, during developing the android applications?", "A. Third-party emulators","B. Emulator included in Android SDK","C. Physical android phone","D. All of the above","d","Answer: (d) All of the above\n" +
                "\n" +
                "We can use the Android emulator, physical android phone, or third-party emulator as a target device to execute and test our Android application.")
        val quiz3 = Quiz(3L,"3) Which of the following is not an activity lifecycle callback method?","A. onClick() method", "B. onCreate() method","C. onStart() method","D. onBackPressed() method","d","(d) onBackPressed() method\n" +
                "\n" +
                "Explanation: None.")
        val quiz4 = Quiz(4L,"4) What is the use of content provider in Android?","A. For storing the data in the database", "B. For sharing the data between applications","C. For sending the data from an application to another application","D. None of the above","c","Answer: (c) For sending the data from an application to another application\n" +
                "\n" +
                "Explanation: A content provider is used to share information between Android applications")
        val quiz5 = Quiz(5L,"5) Which of the following android component displays the part of an activity on screen?","A. View", "B. Manifest","C. Intent","D. Fragment","d","Answer: (d) Fragment\n" +
                "\n" +
                "Explanation: Android Fragment is the part of activity; it is also known as sub-activity. There can be more than one fragment in an activity. Fragments represent multiple screens inside one activity.")
        val quiz6 = Quiz(6L,"6) Which of the following is the parent class of Activity?","A. context", "B. object","C. contextThemeWrapper","D. None of the above","c","Answer: (c) contextThemeWrapper\n" +
                "\n" +
                "Explanation: The android Activity is the subclass of ContextThemeWrapper class. Android Activity Lifecycle is controlled by 7 methods of android.app.Activity class. An activity is a single screen in android. It is like a window or frame of Java.")
        val quiz7 = Quiz(7L,"7) APK stands for -","A. Android Phone Kit", "B. Android Page Kit","C. Android Package Kit","D. None of the above","c","Answer: (c) Android Package Kit\n" +
                "\n" +
                "Explanation: An APK is a short form of the Android Package Kit. An APK file is the file format used to install the applications on the android operating system.")
        val quiz8 = Quiz(12L,"12) How can we kill an activity in android?","A. Using finish() method", "B. Using finishActivity(int requestCode)","C. Both (a) and (b)","D. Neither (a) nor (b)","c","Answer: (c) Both (a) and (b)\n" +
                "\n" +
                "Explanation: The finish() method is used to close the activity. Whereas the finishActivity(int requestCode) also closes the activity with requestCode.")
        val quiz9 = Quiz(13L,"13)  In which state the activity is, if it is not in focus, but still visible on the screen?","A. Stopped state", "B. Destroyed state","C. Paused state","D. Running state","c","Answer: (c) Paused state\n" +
                "\n" +
                "Explanation: When an activity is not in focus that is not interacting with the user but still visible on the screen, then the activity is in paused state.")
        val quiz10 = Quiz(14L,"14) On which of the following, developers can test the application, during developing the android applications?",
            "A. Third-party emulators", "B. Emulator included in Android SDK","C. Physical android phone","D. All of the above","d","Answer: (d) All of the above\n" +
                    "\n" +
                    "Explanation: We can use the Android emulator, physical android phone, or third-party emulator as a target device to execute and test our Android application.")
        val quiz11 = Quiz(8L,"8) What does API stand for?","A. Application Programming Interface", "B. Android Programming Interface","C. Android Page Interface","D. Application Page Interface","a","Answer: (a) Application Programming Interface\n" +
                "\n" +
                "Explanation: API stands for application program interface. It is a set of routines, protocols, and tools for building software and applications. It may be any type of system like a web-based system, operating system, or database system.")
        val quiz12 = Quiz(9L,"9) Which of the following converts Java byte code into Dalvik byte code?","A. Dalvik converter", "B. Dex compiler","C. Mobile interpretive compiler (MIC)","D. None of the above","b","Answer: (b) Dex compiler\n" +
                "\n" +
                "Explanation: The Dex compiler converts the class files into a .dex file that runs on the Dalvik VM. Multiple class files are converted into one dex file.")
        val quiz13 = Quiz(10L,"10) How can we stop the services in android?","A. By using the stopSelf() and stopService() method", "B. By using the finish() method","C. By using system.exit() method","D. None of the above","a","Answer: (a) By using the stopSelf() and stopService() method\n" +
                "\n" +
                "Explanation: A service is started when a component (like activity) calls the startService() method; now, it runs in the background indefinitely. It is stopped by the stopService() method. The service can stop itself by calling the stopSelf() method.")
        val quiz14 = Quiz(11L,"11) Which of the layer is below the topmost layer of android architecture?","A. System Libraries and Android Runtime", "B. Linux Kernel","C. Applications","D. Applications Framework","d","Answer: (d) Applications Framework\n" +
                "\n" +
                "On the top of Native libraries and android runtime, there is an application framework. Android framework includes Android API's such as UI (User Interface), telephony, resources, locations, Content Providers (data), and package managers. It provides a lot of classes and interfaces for android application development.")

        val quiz15 = Quiz(15L,"15) In which of the following tab an error is shown?","A. CPU", "B. Memory","C. ADB Logs","D. Logcat","c","Answer: (d) Logcat\n" +
                "\n" +
                "Explanation: Logcat is a command-line tool that dumps a log of system messages. It includes the messages that you have written from your app with the Log class and also includes the stack traces when the devices throw an error. Logcat helps to analyze the problems and also helps to display the log messages of our android device.")

        launch {
            context?.let {
                QuizDB(it)
                    .getQuizDao().deleteAllQuiz()
                QuizDB(it)
                    .getQuizDao().addQuizzes(quiz1,quiz2,quiz3,quiz4,quiz5,quiz6,quiz7,quiz8,
                    quiz9,quiz10,quiz11,quiz12,quiz13,quiz14,quiz15)
            }
        }
    }

}