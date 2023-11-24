package com.polyshoes.model.sanpham;

import java.security.SecureRandom;
import java.util.Random;

public class SanPham {

        private int id;
        private String ma;
        private String ten;
        private String moTa;
        private int soLuong;
        private boolean trangThai = true; // đang bán

        private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        private static final int CODE_LENGTH = 7;

        public SanPham() {
        }
        
         public SanPham(int id, String ma, String ten, String moTa, boolean trangThai) {
                this.id = id;
                this.ma = ma;
                this.ten = ten;
                this.moTa = moTa;
                this.trangThai = trangThai;
        }

        public SanPham(int id, String ma, String ten, String moTa, int soLuong, boolean trangThai) {
                this.id = id;
                this.ma = ma;
                this.ten = ten;
                this.moTa = moTa;
                this.soLuong = soLuong;
                this.trangThai = trangThai;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }
        
        public String getMa() {
                return ma;
        }

        public void setMa(String ma) {
                this.ma = ma;
        }

        public String getTen() {
                return ten;
        }

        public void setTen(String ten) {
                this.ten = ten;
        }

        public String getMoTa() {
                return moTa;
        }

        public void setMoTa(String moTa) {
                this.moTa = moTa;
        }

        public int getSoLuong() {
                return soLuong;
        }

        public void setSoLuong(int soLuong) {
                this.soLuong = soLuong;
        }
        
        public boolean isTrangThai() {
                return trangThai;
        }

        public void setTrangThai(boolean trangThai) {
                this.trangThai = trangThai;
        }

        @Override
        public String toString() {
                return this.ma;
        }

        public Object[] toInsert() {
                this.setMa(generateCode());
                return new Object[]{this.ma, this.ten, this.moTa, this.soLuong, this.trangThai};
        }
        
        public static String generateCode() {
                Random random = new SecureRandom();
                StringBuilder code = new StringBuilder(CODE_LENGTH);
                for (int i = 0; i < CODE_LENGTH; i++) {
                        int randomIndex = random.nextInt(CHARACTERS.length());
                        code.append(CHARACTERS.charAt(randomIndex));
                }
                return "SP-" + code.toString();
        }

}
