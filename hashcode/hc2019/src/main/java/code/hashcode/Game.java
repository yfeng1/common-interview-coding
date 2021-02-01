/**
 *  Copyright Murex S.A.S., 2003-2019. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package code.hashcode;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class Game {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields
    //~ ----------------------------------------------------------------------------------------------------------------

    public List<Photo> photos = new ArrayList<>();
    public List<Slide> slides = new ArrayList<>();
    public List<Slide> maximum = new ArrayList<>();
    public int globalInteration;
    public int localInteration;
    public double temperature;
    public float reductTempRatio;
    Random random = new Random(System.currentTimeMillis());

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors
    //~ ----------------------------------------------------------------------------------------------------------------

    public Game(int globalInteration, int localInteration, double temperature, float reductTempRatio) {
        this.globalInteration = globalInteration;
        this.localInteration = localInteration;
        this.temperature = temperature;
        this.reductTempRatio = reductTempRatio;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public void addPhoto(Photo photo) {
        this.photos.add(photo);
    }

    public void addSlide(Slide slide) {
        this.slides.add(slide);
    }

    public void run() {
        init();
        runCore();
    }

    public void runWithFile(String fileName) throws FileNotFoundException {
        initFromFile(fileName);
        runCore();
    }

    public void runWithFileSwitchRange(String fileName) throws FileNotFoundException {
        initFromFile(fileName);
        runCoreWithReverse();
    }

    public void init() {
        // Init slide
        Photo vPhoto = null;
        for (Photo photo : photos) {
            if (!photo.isVertical()) {
                slides.add(new HorizonSlide(photo));
            } else {
                if (vPhoto == null) {
                    vPhoto = photo;
                } else {
                    slides.add(new VerticalSlide(vPhoto, photo));
                    vPhoto = null;
                }
            }
        }
    }

    public void initFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int nbSlides = scanner.nextInt();
        scanner.nextLine();

        // Jump the first line
        for (int i = 0; i < nbSlides; i++) {
            String nextLine = scanner.nextLine();
            String[] splited = nextLine.split(" ");
            if (splited.length == 1) {
                slides.add(new HorizonSlide(photos.get(Integer.parseInt(splited[0]))));
            } else if (splited.length == 2) {
                slides.add(new VerticalSlide(photos.get(Integer.parseInt(splited[0])), photos.get(Integer.parseInt(splited[1]))));
            }
        }
    }

    static int evaluate(Slide slide1, Slide slide2) {
        Set<String> tags1 = slide1.getTags();
        Set<String> tags2 = slide2.getTags();

        int common = 0;
        for (String tag : tags2) {
            if (tags1.contains(tag)) {
                common++;
            }
        }

        return Math.min(common, Math.min(tags1.size() - common, tags2.size() - common));
    }

    int deltaReverseRange(int first, int second) {
        if (second < first) {
            int temp = first;
            first = second;
            second = temp;
        }

        if ((first == (second - 1)) || (first == (second - 2))) {
            return delta(first, second);
        } else {
            int pointToRemove = calculateTransaction(first, slides.get(first)) + calculateTransaction(second, slides.get(second));
            swap2slides(first, second, slides);
            swap2slides(first + 1, second - 1, slides);
            int pointToAdd = calculateTransaction(first, slides.get(first)) + calculateTransaction(second, slides.get(second));
            swap2slides(first, second, slides);
            swap2slides(first + 1, second - 1, slides);
            return pointToAdd - pointToRemove;
        }
    }

    int delta(int first, int second) {
        int pointToRemove = calculateTransaction(first, slides.get(first)) + calculateTransaction(second, slides.get(second));
        swap2slides(first, second, slides);
        int pointToAdd = calculateTransaction(first, slides.get(first)) + calculateTransaction(second, slides.get(second));
        // Swap back
        swap2slides(first, second, slides);
        return pointToAdd - pointToRemove;
    }

    int deltaSwapPhoto(int first, int second) {
        VerticalSlide slide1 = (VerticalSlide) slides.get(first);
        VerticalSlide slide2 = (VerticalSlide) slides.get(second);
        VerticalSlide newSlide1 = new VerticalSlide(slide2.photo2, slide1.photo2);
        VerticalSlide newSlide2 = new VerticalSlide(slide2.photo1, slide1.photo1);

        int pointToRemove = calculateTransaction(first, slides.get(first)) + calculateTransaction(second, slides.get(second));
        slides.set(first, newSlide1);
        slides.set(second, newSlide2);
        int pointToAdd = calculateTransaction(first, newSlide1) + calculateTransaction(second, newSlide2);

        slides.set(first, slide1);
        slides.set(second, slide2);

        return pointToAdd - pointToRemove;
    }

    private int calculateTransaction(int slidePosition, Slide slide) {
        //J-
        return    ((slidePosition > 0) ? evaluate(slide, slides.get(slidePosition - 1)) : 0)
                + (slidePosition < (slides.size() - 1) ? evaluate(slides.get(slidePosition), slides.get(slidePosition + 1)) : 0);
        //J+
    }

    private void swapWithRangeReverse(int first, int second, boolean vertical, boolean vertical1, boolean verticalSwap) {
        if (vertical && vertical1 && verticalSwap) {
            VerticalSlide slide1 = (VerticalSlide) slides.get(first);
            VerticalSlide slide2 = (VerticalSlide) slides.get(second);
            VerticalSlide newSlide1 = new VerticalSlide(slide2.photo2, slide1.photo2);
            VerticalSlide newSlide2 = new VerticalSlide(slide2.photo1, slide1.photo1);
            slides.set(first, newSlide1);
            slides.set(second, newSlide2);
        } else {
            // swap range
            swapRange(first, second);
        }
    }

    private void swapRange(int first, int second) {
        List<Slide> slides = this.slides.subList(first, second + 1);
        for (int i1 = 0; i1 < (slides.size() / 2); i1++) {
            swap2slides(i1, slides.size() - 1 - i1, slides);
        }
    }

    private void runCore() {
        // We have a solution
//        nextSlides = evaluateGlobal(slides);
        maximum.addAll(slides);

        int i = 0;
        while (i < globalInteration) {
            int j = 0;
            while (j < localInteration) {
//                nextSlides = evaluateGlobal(slides);

                // switch

                int first, second;
                do {
                    first = random.nextInt(slides.size());
                    second = random.nextInt(slides.size());
                } while (first >= second);

                boolean vertical = slides.get(first).isVertical();
                boolean vertical1 = slides.get(second).isVertical();

                long delta;
                boolean verticalSwap = false;

                if (vertical && vertical1) {
                    float swapVertical = random.nextFloat();
                    if (swapVertical > 0.5) {
                        verticalSwap = true;
                        delta = deltaSwapPhoto(first, second);
                    } else {
                        delta = delta(first, second);
                        verticalSwap = false;
                    }
                } else {
                    delta = delta(first, second);
                }
                if (delta > 0) {
                    // Keep the best
                    switchStandard(first, second, vertical, vertical1, verticalSwap);
                    maximum.clear();
                    maximum.addAll(slides);
                }
                else if ((((300 + delta) / temperature) > random.nextFloat())) {
                    // switch slides
                    switchStandard(first, second, vertical, vertical1, verticalSwap);
                }
                j++;
            }
            temperature = reductTempRatio * temperature;
            i++;
        }
        slides = maximum;
    }

    private void runCoreWithReverse() {
        // We have a solution
//        nextSlides = evaluateGlobal(slides);
        maximum.addAll(slides);
        int maximumTransactions = 0;
        int i = 0;
        int currentTransactions = 0;
        while (i < globalInteration) {
            int j = 0;
            while (j < localInteration) {
//                nextSlides = evaluateGlobal(slides);

                // switch
                int first, second;
                do {
                    first = random.nextInt(slides.size());
                    second = random.nextInt(slides.size());
                } while (first >= second);

                boolean vertical = slides.get(first).isVertical();
                boolean vertical1 = slides.get(second).isVertical();

                long delta;
                boolean verticalSwap = false;
                if (vertical && vertical1) {
                    float swapVertical = random.nextFloat();
                    if (swapVertical > 0.4) {
                        verticalSwap = true;
                        delta = deltaSwapPhoto(first, second);
                    } else {
                        delta = deltaReverseRange(first, second);
                        verticalSwap = false;
                    }
                } else {
                    delta = deltaReverseRange(first, second);
                }
                if (delta > 0) {
                    // Keep the best
                    swapWithRangeReverse(first, second, vertical, vertical1, verticalSwap);
                    currentTransactions += delta;
                    if (maximumTransactions < currentTransactions) {
                        maximum.clear();
                        maximum.addAll(slides);
                        maximumTransactions = currentTransactions;
                    }
                }
                else {
                    double test = (300 + delta) / temperature;
//                    System.err.println("temp random : " + test);
                    if ((test > random.nextFloat())) {
                        // switch slides
                        swapWithRangeReverse(first, second, vertical, vertical1, verticalSwap);
                        currentTransactions += delta;
                    }
                }
                j++;
            }
            temperature = reductTempRatio * temperature;
            i++;
        }
        slides = maximum;
    }

    private void switchStandard(int first, int second, boolean vertical, boolean vertical1, boolean verticalSwap) {
        if (vertical && vertical1 && verticalSwap) {
            VerticalSlide slide1 = (VerticalSlide) slides.get(first);
            VerticalSlide slide2 = (VerticalSlide) slides.get(second);
            VerticalSlide newSlide1 = new VerticalSlide(slide2.photo2, slide1.photo2);
            VerticalSlide newSlide2 = new VerticalSlide(slide2.photo1, slide1.photo1);
            slides.set(first, newSlide1);
            slides.set(second, newSlide2);
        } else {
            swap2slides(first, second, slides);
        }
    }

    private void swap2slides(int first, int second, List<Slide> slides) {
        Slide firstSlide = slides.get(first);
        slides.set(first, slides.get(second));
        slides.set(second, firstSlide);
    }

}
