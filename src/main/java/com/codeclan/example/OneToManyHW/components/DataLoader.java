package com.codeclan.example.OneToManyHW.components;

import com.codeclan.example.OneToManyHW.models.File;
import com.codeclan.example.OneToManyHW.models.Folder;
import com.codeclan.example.OneToManyHW.models.User;
import com.codeclan.example.OneToManyHW.repositories.FileRepository;
import com.codeclan.example.OneToManyHW.repositories.FolderRepository;
import com.codeclan.example.OneToManyHW.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        User ash = new User("Ash");
        userRepository.save(ash);

        User matilda = new User("Matilda");
        userRepository.save(matilda);

        Folder folder1 = new Folder("Holiday", ash);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("CV", ash);
        folderRepository.save(folder2);

        Folder folder3 = new Folder("toys", matilda);
        folderRepository.save(folder3);

        File file1 = new File("holidayPic", ".jpg", 3, folder1);
        fileRepository.save(file1);

        File file2 = new File("newCV", ".doc", 2, folder2);
        fileRepository.save(file2);

        File file3 = new File("Doll", ".jpg", 2, folder3);
        fileRepository.save(file3);



        folder1.addFiles(file1);
        folderRepository.save(folder1);

        folder2.addFiles(file2);
        folderRepository.save(folder2);

        ash.addFolders(folder1);
        ash.addFolders(folder2);
        userRepository.save(ash);





    }


}
