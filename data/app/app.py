from fastapi import FastAPI
from pydantic import BaseModel
import pandas as pd
from joblib import load
import os

app = FastAPI()

# 입력 데이터 모델 정의
class InputData(BaseModel):
    Date: str
    Region: str
    Max_Temp:float
    Min_Temp:float
    pressure:float
    Humidity:float
    total_rain:float
    Max_rain:float
    wind_speed:float


class InputData2(BaseModel):
    Date: str
    Region: str
    Average_Temperature:float
    Max_Temp:float
    Min_Temp:float
    pressure:float
    Humidity:float
    Max_rain:float
    wind_speed:float    


# 모델을 로드합니다.
model_path = "mldt1.dump"
if os.path.exists(model_path):
    model = load(model_path)
else:
    raise FileNotFoundError(f"Model file '{model_path}' not found.")

model2_path = "mldt2.dump"
if os.path.exists(model2_path):
    model2 = load(model2_path)
else:
    raise FileNotFoundError(f"Model file '{model2_path}' not found.")

# 모델 학습 시 사용된 피처 이름을 확인합니다.
feature_names = model.feature_names_in_
feature_names_model2 = model2.feature_names_in_

@app.post("/predict")
def predict(data: InputData):
    # 입력 데이터를 데이터프레임으로 변환
    input_dict = data.dict()
    
    # Date 열에서 Year와 Month를 추출
    year, month = map(int, input_dict['Date'].split('-'))
    input_dict['Year'] = year
    input_dict['Month'] = month
    
    # 불필요한 Date 열을 삭제
    del input_dict['Date']
    
    input_dict['Average Maximum Temperature (°C)'] = input_dict.pop('Max_Temp')
    input_dict['Average Minimum Temperature (°C)'] = input_dict.pop('Min_Temp')
    input_dict['Average Local Pressure (hPa)'] = input_dict.pop('pressure')
    input_dict['Average Relative Humidity (%)'] = input_dict.pop('Humidity')
    input_dict['Monthly Total Rainfall (mm)'] = input_dict.pop('total_rain')
    input_dict['Daily Maximum Rainfall (mm)'] = input_dict.pop('Max_rain')
    input_dict['Average Wind Speed (m/s)'] = input_dict.pop('wind_speed')
    
    
    # 입력 데이터프레임 생성
    input_df = pd.DataFrame([input_dict])
    
    # 필요한 피처 목록
    features = [
        'Average Maximum Temperature (°C)', 
        'Average Minimum Temperature (°C)', 'Average Local Pressure (hPa)', 
        'Average Relative Humidity (%)', 'Monthly Total Rainfall (mm)', 
        'Daily Maximum Rainfall (mm)', 'Average Wind Speed (m/s)', 'Month'
    ]
    
    # 원-핫 인코딩을 위한 설정
    regions = ['강원', '경남', '경북', '광주', '대구', '대전', '부산', '서울', '울산', '인천', '전남', '전북', '제주', '충남', '충북']
    years = list(range(2014, 2021))
    
    # Region을 원-핫 인코딩 수행
    for region in regions:
        input_df[f'Region_{region}'] = 1 if input_dict['Region'] == region else 0
    
    # Year을 원-핫 인코딩 수행
    for y in years:
        input_df[f'Year_{y}'] = 1 if year == y else 0
    
    # Region 및 Year 원-핫 인코딩된 피처 추가
    features += [f'Region_{region}' for region in regions]
    features += [f'Year_{y}' for y in years]
    
    # 데이터프레임을 모델이 기대하는 피처 순서로 재배열
        # 피처 순서를 모델이 학습할 때 사용된 순서로 재배열
    input_df = input_df.reindex(columns=feature_names).fillna(0)
    
    # 모델 예측
    prediction = model.predict(input_df)
    
    return {"prediction": prediction[0]}

# 실행 중인 FastAPI 애플리케이션을 디버깅하고 테스트하기 위해 아래 코드를 실행할 수 있습니다.
# uvicorn main:app --reload

@app.post("/predict Rain")
def predict_rainfall(data: InputData2):
    input_dict = data.dict()
    year, month = map(int, input_dict['Date'].split('-'))  # 날짜 형식이 YYYY-MM이라고 가정
    input_dict['Year'] = year
    input_dict['Month'] = month
    del input_dict['Date']

    input_dict['Average Maximum Temperature (°C)'] = input_dict.pop('Max_Temp')
    input_dict['Average Minimum Temperature (°C)'] = input_dict.pop('Min_Temp')
    input_dict['Average Local Pressure (hPa)'] = input_dict.pop('pressure')
    input_dict['Average Relative Humidity (%)'] = input_dict.pop('Humidity')
    input_dict['Daily Maximum Rainfall (mm)'] = input_dict.pop('Max_rain')
    input_dict['Average Wind Speed (m/s)'] = input_dict.pop('wind_speed')

    input_df = pd.DataFrame([input_dict])
    regions = ['강원', '경남', '경북', '광주', '대구', '대전', '부산', '서울', '울산', '인천', '전남', '전북', '제주', '충남', '충북']
    years = list(range(2014, 2021))

    for region in regions:
        input_df[f'Region_{region}'] = 1 if input_dict['Region'] == region else 0
    for y in years:
        input_df[f'Year_{y}'] = 1 if year == y else 0

    months = list(range(1, 13))
    for m in months:
        input_df[f'Month_{m}'] = 1 if month == m else 0

    input_df = input_df.reindex(columns=feature_names_model2).fillna(0)
    prediction = model2.predict(input_df)
    return {"prediction": prediction[0]}

@app.get('/')
async def root():
    return {"message": "online"}