package com.chaochaowu.facedetect.bean;

import java.util.List;

/**
 * 面部识别结果的bean
 * @author chaochaowu
 */
public class FaceppBean {
    /**
     * image_id : Dd2xUw9S/7yjr0oDHHSL/Q==
     * request_id : 1470472868,dacf2ff1-ea45-4842-9c07-6e8418cea78b
     * time_used : 752
     * faces : [{"landmark":{"mouth_upper_lip_left_contour2":{"y":185,"x":146},"contour_chin":{"y":231,"x":137},"right_eye_pupil":{"y":146,"x":205},"mouth_upper_lip_bottom":{"y":195,"x":159}},"attributes":{"gender":{"value":"Female"},"age":{"value":21},"glass":{"value":"None"},"headpose":{"yaw_angle":-26.625063,"pitch_angle":12.921974,"roll_angle":22.814377},"smile":{"threshold":30.1,"value":2.566890001296997}},"face_rectangle":{"width":140,"top":89,"left":104,"height":141},"face_token":"ed319e807e039ae669a4d1af0922a0c8"}]
     */

    private String image_id;
    private String request_id;
    private int time_used;
    private List<FacesBean> faces;

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public int getTime_used() {
        return time_used;
    }

    public void setTime_used(int time_used) {
        this.time_used = time_used;
    }

    public List<FacesBean> getFaces() {
        return faces;
    }

    public void setFaces(List<FacesBean> faces) {
        this.faces = faces;
    }

    public static class FacesBean {
        /**
         * landmark : {"mouth_upper_lip_left_contour2":{"y":185,"x":146},"contour_chin":{"y":231,"x":137},"right_eye_pupil":{"y":146,"x":205},"mouth_upper_lip_bottom":{"y":195,"x":159}}
         * attributes : {"gender":{"value":"Female"},"age":{"value":21},"glass":{"value":"None"},"headpose":{"yaw_angle":-26.625063,"pitch_angle":12.921974,"roll_angle":22.814377},"smile":{"threshold":30.1,"value":2.566890001296997}}
         * face_rectangle : {"width":140,"top":89,"left":104,"height":141}
         * face_token : ed319e807e039ae669a4d1af0922a0c8
         */

        private LandmarkBean landmark;
        private AttributesBean attributes;
        private FaceRectangleBean face_rectangle;
        private String face_token;

        public LandmarkBean getLandmark() {
            return landmark;
        }

        public void setLandmark(LandmarkBean landmark) {
            this.landmark = landmark;
        }

        public AttributesBean getAttributes() {
            return attributes;
        }

        public void setAttributes(AttributesBean attributes) {
            this.attributes = attributes;
        }

        public FaceRectangleBean getFace_rectangle() {
            return face_rectangle;
        }

        public void setFace_rectangle(FaceRectangleBean face_rectangle) {
            this.face_rectangle = face_rectangle;
        }

        public String getFace_token() {
            return face_token;
        }

        public void setFace_token(String face_token) {
            this.face_token = face_token;
        }

        public static class LandmarkBean {
            /**
             * mouth_upper_lip_left_contour2 : {"y":185,"x":146}
             * contour_chin : {"y":231,"x":137}
             * right_eye_pupil : {"y":146,"x":205}
             * mouth_upper_lip_bottom : {"y":195,"x":159}
             */

            private MouthUpperLipLeftContour2Bean mouth_upper_lip_left_contour2;
            private ContourChinBean contour_chin;
            private RightEyePupilBean right_eye_pupil;
            private MouthUpperLipBottomBean mouth_upper_lip_bottom;

            public MouthUpperLipLeftContour2Bean getMouth_upper_lip_left_contour2() {
                return mouth_upper_lip_left_contour2;
            }

            public void setMouth_upper_lip_left_contour2(MouthUpperLipLeftContour2Bean mouth_upper_lip_left_contour2) {
                this.mouth_upper_lip_left_contour2 = mouth_upper_lip_left_contour2;
            }

            public ContourChinBean getContour_chin() {
                return contour_chin;
            }

            public void setContour_chin(ContourChinBean contour_chin) {
                this.contour_chin = contour_chin;
            }

            public RightEyePupilBean getRight_eye_pupil() {
                return right_eye_pupil;
            }

            public void setRight_eye_pupil(RightEyePupilBean right_eye_pupil) {
                this.right_eye_pupil = right_eye_pupil;
            }

            public MouthUpperLipBottomBean getMouth_upper_lip_bottom() {
                return mouth_upper_lip_bottom;
            }

            public void setMouth_upper_lip_bottom(MouthUpperLipBottomBean mouth_upper_lip_bottom) {
                this.mouth_upper_lip_bottom = mouth_upper_lip_bottom;
            }

            public static class MouthUpperLipLeftContour2Bean {
                /**
                 * y : 185
                 * x : 146
                 */

                private int y;
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourChinBean {
                /**
                 * y : 231
                 * x : 137
                 */

                private int y;
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyePupilBean {
                /**
                 * y : 146
                 * x : 205
                 */

                private int y;
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthUpperLipBottomBean {
                /**
                 * y : 195
                 * x : 159
                 */

                private int y;
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }
        }

        public static class AttributesBean {
            /**
             * gender : {"value":"Female"}
             * age : {"value":21}
             * glass : {"value":"None"}
             * headpose : {"yaw_angle":-26.625063,"pitch_angle":12.921974,"roll_angle":22.814377}
             * smile : {"threshold":30.1,"value":2.566890001296997}
             */

            private GenderBean gender;
            private AgeBean age;
            private GlassBean glass;
            private HeadposeBean headpose;
            private SmileBean smile;
            private BeautyBean beauty;
            private EmotionBean emotion;

            public GenderBean getGender() {
                return gender;
            }

            public void setGender(GenderBean gender) {
                this.gender = gender;
            }

            public AgeBean getAge() {
                return age;
            }

            public void setAge(AgeBean age) {
                this.age = age;
            }

            public GlassBean getGlass() {
                return glass;
            }

            public void setGlass(GlassBean glass) {
                this.glass = glass;
            }

            public HeadposeBean getHeadpose() {
                return headpose;
            }

            public void setHeadpose(HeadposeBean headpose) {
                this.headpose = headpose;
            }

            public SmileBean getSmile() {
                return smile;
            }

            public void setSmile(SmileBean smile) {
                this.smile = smile;
            }

            public BeautyBean getBeauty() {
                return beauty;
            }

            public void setSmile(BeautyBean beauty) {
                this.beauty = beauty;
            }

            public EmotionBean getEmotion() {
                return emotion;
            }

            public void setEmotion(EmotionBean emotion) {
                this.emotion = emotion;
            }



            public static class GenderBean {
                /**
                 * value : Female
                 */

                private String value;

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class AgeBean {
                /**
                 * value : 21
                 */

                private int value;

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class GlassBean {
                /**
                 * value : None
                 */

                private String value;

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class HeadposeBean {
                /**
                 * yaw_angle : -26.625063
                 * pitch_angle : 12.921974
                 * roll_angle : 22.814377
                 */

                private double yaw_angle;
                private double pitch_angle;
                private double roll_angle;

                public double getYaw_angle() {
                    return yaw_angle;
                }

                public void setYaw_angle(double yaw_angle) {
                    this.yaw_angle = yaw_angle;
                }

                public double getPitch_angle() {
                    return pitch_angle;
                }

                public void setPitch_angle(double pitch_angle) {
                    this.pitch_angle = pitch_angle;
                }

                public double getRoll_angle() {
                    return roll_angle;
                }

                public void setRoll_angle(double roll_angle) {
                    this.roll_angle = roll_angle;
                }
            }

            public static class SmileBean {
                /**
                 * threshold : 30.1
                 * value : 2.566890001296997
                 */

                private double threshold;
                private double value;

                public double getThreshold() {
                    return threshold;
                }

                public void setThreshold(double threshold) {
                    this.threshold = threshold;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class BeautyBean {
                /**
                 * value : None
                 */

                private double male_score;
                private double female_score;

                public double getMale_score() {
                    return male_score;
                }

                public void setMale_score(double male_score) {
                    this.male_score = male_score;
                }

                public double getFemale_score() {
                    return female_score;
                }

                public void setFemale_score(double female_score) {
                    this.female_score = female_score;
                }

            }

            public static class EmotionBean {
                /**
                 * value : None
                 */

                private double anger;
                private double disgust;
                private double fear;
                private double happiness;
                private double neutral;
                private double sadness;
                private double surprise;

                public double getAnger() {
                    return anger;
                }

                public void setAnger(double anger) {
                    this.anger = anger;
                }

                public double getDisgust() {
                    return disgust;
                }

                public void setDisgust(double disgust) {
                    this.disgust = disgust;
                }

                public double getFear() {
                    return fear;
                }

                public void setFear(double fear) {
                    this.fear = fear;
                }

                public double getHappiness() {
                    return happiness;
                }

                public void setHappiness(double happiness) {
                    this.happiness = happiness;
                }

                public double getNeutral() {
                    return neutral;
                }

                public void setNeutral(double neutral) {
                    this.neutral = neutral;
                }

                public double getSadness() {
                    return sadness;
                }

                public void setSadness(double sadness) {
                    this.sadness = sadness;
                }

                public double getSurprise() {
                    return surprise;
                }

                public void setSurprise(double surprise) {
                    this.surprise = surprise;
                }
            }
        }

        public static class FaceRectangleBean {
            /**
             * width : 140
             * top : 89
             * left : 104
             * height : 141
             */

            private int width;
            private int top;
            private int left;
            private int height;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }
    }
}
