package Unit5;

import Unit1.Student;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ConcurrencyDemo {
    public static void main(String[] args) {

        CompletableFutureRunAsyncExample();

        CompletableFutureSupplyAsyncExample();

        CompletableFutureThenApplyExample();

        CompletableFutureThenComposeExample();

        CompletableFutureThenCombineExample();
    }

    /**
     * An Example of thenCombine() of CompletableFuture ( combining two independent Future )
     */
    private static void CompletableFutureThenCombineExample() {
        CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 65.0;
        });

        CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 177.8;
        });
        System.out.println("Calculating BMI.");
        CompletableFuture<Double> combinedFuture = weightInKgFuture
                .thenCombine(heightInCmFuture, (weightInKg, heightInCm) -> {
                    Double heightInMeter = heightInCm/100;
                    return weightInKg/(heightInMeter*heightInMeter);
                });
        try {
            System.out.println("BMI = "+combinedFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * An Example of thenCompose() of CompletableFuture ( Combining two Future that are dependent on each other )
     */
    private static void CompletableFutureThenComposeExample() {
        Student student = new Student(102,"student", List.of(45, 65, 70, 25, 98),"Ramesh", "Shakuntala", 16);
        CompletableFuture<Integer> result = getTotalMarks(student)
                .thenCompose(total -> getPercentage(total));
        try {
            System.out.println("Percentage = "+result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static CompletableFuture<Integer> getTotalMarks(Student student) {
        return CompletableFuture.supplyAsync(() -> {
            return student.getSubjectMarks().stream().reduce(0, (a, b) -> a + b);
        });
    }

    private static CompletableFuture<Integer> getPercentage(Integer total) {
        return CompletableFuture.supplyAsync(() -> {
            return total/5;
        });
    }

    /**
     * An Example of thenApply() of CompletableFuture ( Chaining)
     */
    private static void CompletableFutureThenApplyExample() {
        CompletableFuture<String> returnString = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Akhil";
        }).thenApply(name -> {
            return "Hello " + name;
        }).thenApply(greeting -> {
            return greeting + ", Welcome to the Digit 88.";
        });

        try {
            System.out.println(returnString.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * An Example of supplyAsync() of CompletableFuture
     * @return
     */
    private static void CompletableFutureSupplyAsyncExample() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "process is completed";
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * An Example of runAsync() of CompletableFuture
     */
    private static void CompletableFutureRunAsyncExample() {
        CompletableFuture<Void> future =  CompletableFuture.runAsync(()->  {
            // Simulate a long-running Job
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("some background verification ");

        });
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
